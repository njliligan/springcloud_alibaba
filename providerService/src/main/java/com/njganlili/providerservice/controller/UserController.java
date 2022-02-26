package com.njganlili.providerservice.controller;

import com.njganlili.commonservice.model.User;
import com.njganlili.providerservice.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Value("${nacos.info}")
    private String info;

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/add")
    public Integer addUser(@RequestBody User user){
        Integer b = userServiceImpl.addUser(user);
        System.out.println("received msg.........");
        System.out.println(info);
        return b;
    }

}
