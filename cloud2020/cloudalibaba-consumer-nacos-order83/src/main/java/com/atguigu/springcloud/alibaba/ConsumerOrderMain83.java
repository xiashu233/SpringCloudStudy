package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// 注册服务进 nacos
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerOrderMain83 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderMain83.class,args);
    }
}
