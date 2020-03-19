package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;

    @Override
    public int Add(Payment payment) {
        return paymentDao.Insert(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.SelectPaymentById(id);
    }
}
