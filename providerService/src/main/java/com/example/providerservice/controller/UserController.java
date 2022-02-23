package com.example.providerservice.controller;

import com.njganlili.commonservice.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author njgan
 * @description
 * @date 2022/2/20 20:21
 */
@RefreshScope
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${dates.b}")
    private int b;

    @Value("${nacos.info}")
    private String info;

    @PostMapping("/add")
    public Integer addUser(User user){
        System.out.println("received msg.........");
        System.out.println(b);
        System.out.println(info);
        return b;
    }

}
