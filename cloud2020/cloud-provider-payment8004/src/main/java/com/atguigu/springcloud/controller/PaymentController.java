package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @ResponseBody
    @RequestMapping(value = "/payment/zk")
    public String paymentZk(){

        return "SpringCloud with Zookeeper:" + serverPort + UUID.randomUUID().toString();
    }


}
