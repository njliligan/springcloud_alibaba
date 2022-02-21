package com.njganlili.consumeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumeServiceApplication.class, args);
    }

}
