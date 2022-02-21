package com.njganlili.consumeservice.controller;

import com.njganlili.commonservice.model.User;
import com.njganlili.consumeservice.fegin.FeignClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author njgan
 * @description
 * @date 2022/2/21 15:59
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger loger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private FeignClients feignClients;

    @GetMapping("/addUser")
    public void addUser(){
        User user = new User();
        Integer result = feignClients.addUser(user);
        loger.info(String.valueOf(result));
    }

}
