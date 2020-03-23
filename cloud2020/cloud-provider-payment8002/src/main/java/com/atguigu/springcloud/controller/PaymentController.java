package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/insert")
    @ResponseBody
    public CommonResult Insert(@RequestBody Payment payment){
        Integer result = paymentService.Add(payment);
        log.info("****插入结果：" + result);
        if (result > 0){
            return new CommonResult(200,"插入数据库成功,ServerPort:" + serverPort,result);
        }
        return new CommonResult(444,"插入数据库失败,ServerPort:" + serverPort);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> Insert(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("****插入结果：" + payment);
        if (payment != null){
            return new CommonResult(200,"查询数据库成功,ServerPort:" + serverPort,payment);
        }
        return new CommonResult(444,"查询数据库失败,ServerPort:" + serverPort);
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



}
