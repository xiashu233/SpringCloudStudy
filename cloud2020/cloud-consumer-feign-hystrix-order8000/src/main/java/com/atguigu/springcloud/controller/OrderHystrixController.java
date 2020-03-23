package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/hystrix/paymentInfo_OK/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/hystrix/paymentInfo_Error/{id}")
    // 异常后调用 paymentInfo_ErrorHandler 方法
//    @HystrixCommand(fallbackMethod = "paymentInfo_ErrorFallbackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })
    @HystrixCommand
    public String paymentInfo_Error(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentInfo_Error(id);
    }

    public String paymentInfo_ErrorFallbackMethod(@PathVariable("id") Integer id){
        return "不好意思，服务调用中发生了错误或超时,id：" + id;
    }

    public String payment_Global_FallbackMethod(){
        return "不好意思，服务调用中发生了错误或超时,id：" ;
    }

}
