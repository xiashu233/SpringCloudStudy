package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StreamMqMain8803 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMqMain8803.class,args);
    }
}
