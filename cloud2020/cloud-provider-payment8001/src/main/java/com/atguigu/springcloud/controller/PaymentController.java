package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @PostMapping(value = "/payment/insert")
    public CommonResult Insert(Payment payment){
        Integer result = paymentService.Add(payment);
        log.info("****插入结果：" + result);
        if (result > 0){
            return new CommonResult(200,"插入数据库成功",result);
        }
        return new CommonResult(444,"插入数据库失败");
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult Insert(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("****插入结果：" + payment);
        if (payment != null){
            return new CommonResult(200,"查询数据库成功",payment);
        }
        return new CommonResult(444,"查询数据库失败");
    }


}
