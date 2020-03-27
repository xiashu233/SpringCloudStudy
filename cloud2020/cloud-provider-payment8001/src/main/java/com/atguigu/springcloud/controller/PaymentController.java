package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/insert")
    public CommonResult Insert(@RequestBody Payment payment){
        Integer result = paymentService.Add(payment);
        log.info("****插入结果：" + result);
        if (result > 0){
            return new CommonResult(200,"插入数据库成功,ServerPort:" + serverPort,result);
        }
        return new CommonResult(444,"插入数据库失败,ServerPort:" + serverPort);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("****插入结果：" + payment);
        if (payment != null){
            return new CommonResult(200,"查询数据库成功,ServerPort:" + serverPort,payment);
        }
        return new CommonResult(444,"查询数据库失败,ServerPort:" + serverPort);
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        // 获得所有的微服务名称
        List<String> services = discoveryClient.getServices();
        Map<String,Object> infos = new HashMap<>();
        infos.put("Service",services);

        for (String service : services) {
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            infos.put(service,instances);
        }

        return infos;
    }


    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping(value = "/payment/lb")
    public String paymentGetaway(){

        return "Getaway，Port：" + serverPort;
    }

    @GetMapping(value = "/payment/zipkin")
    public String paymentZipkin(){

        return "调用了服务链路，zipkin进行跟踪";
    }



}
