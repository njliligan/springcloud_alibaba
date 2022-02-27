package com.njganlili.providerservice.controller;


import com.njganlili.commonservice.entity.User;
import com.njganlili.interfaces.provider.service.UserService;
import com.njganlili.providerservice.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author miky
 * @since 2022-02-27
 */
@RefreshScope
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${nacos.info}")
    private String info;

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public Integer addUser(@RequestBody User user){
        Integer b = userService.addUser(user);
        System.out.println("received msg.........");
        System.out.println(info);
        return b;
    }

}


