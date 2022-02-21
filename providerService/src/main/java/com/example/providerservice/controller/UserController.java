package com.example.providerservice.controller;

import com.njganlili.commonservice.model.User;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author njgan
 * @description
 * @date 2022/2/20 20:21
 */
@RefreshScope
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/add")
    public Integer addUser(User user){
        return 1;
    }

}
