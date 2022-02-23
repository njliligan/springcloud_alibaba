package com.njganlili.consumeservice;

import feign.RequestTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author njgan
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumeServiceApplication.class, args);
    }

    @Bean
//    @LoadBalanced //这里就必须使用服务名
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
