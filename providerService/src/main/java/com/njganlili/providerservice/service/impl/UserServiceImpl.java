package com.njganlili.providerservice.service.impl;

import com.njganlili.commonservice.model.User;
import com.njganlili.interfaces.consumer.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author njgan
 * @description
 * @date 2022/2/26 17:51
 */
@DubboService
public class UserServiceImpl implements UserService {

    @Value("${dates.b}")
    private int b;

    public Integer addUser(User user){
        System.out.println(b);
        return b;
    }

}
