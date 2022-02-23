package com.njganlili.consumeservice.fegin;

import com.njganlili.commonservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author njgan
 * @description
 * @date 2022/2/21 15:48
 */
//name是服务名
@FeignClient(name = "provider-service")
@Component
public interface FeignClients {

    @GetMapping("/user/add")
    Integer addUser(User user);

}
