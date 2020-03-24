package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackHystrixService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "---调用 paymentInfo_OK 方法时出现了异常，请稍后重试。。。";
    }

    @Override
    public String paymentInfo_Error(Integer id) {
        return "---调用 paymentInfo_Error 方法时出现了异常，请稍后重试。。。";
    }
}
