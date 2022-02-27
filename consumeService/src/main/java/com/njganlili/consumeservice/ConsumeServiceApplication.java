package com.njganlili.consumeservice;

//import feign.RequestTemplate;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author njgan
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableDubbo
public class ConsumeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumeServiceApplication.class, args);
    }


}
