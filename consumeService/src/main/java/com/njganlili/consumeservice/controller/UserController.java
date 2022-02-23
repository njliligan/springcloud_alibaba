package com.njganlili.consumeservice.controller;

import com.njganlili.commonservice.model.User;
import com.njganlili.consumeservice.fegin.FeignClients;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * @author njgan
 * @description
 * @date 2022/2/21 15:59
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    //会自动转为Post，如果要解决，那就必须加上@RequestParam(“name”)，或者更更换httpClient
    //feign:
    //  httpclient:
    //    enabled: true
    //依赖
    //		<dependency>
    //            <groupId>org.apache.httpcomponents</groupId>
    //            <artifactId>httpclient</artifactId>
    //            <version>4.5.9</version>
    //        </dependency>
    //        <dependency>
    //            <groupId>io.github.openfeign</groupId>
    //            <artifactId>feign-httpclient</artifactId>
    //            <version>10.2.3</version>
    //        </dependency>
    @Autowired
    private FeignClients feignClients;

    //@Autowired
    //private WebClient.Builder webClientBuilder;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/addUser")
    public Integer addUserByFeign(){
        User user = new User();
        Integer result = feignClients.addUser(user);
        logger.info(String.valueOf(result));
        return result;
    }

    @GetMapping("/addUserByRestTemplate")
    public Integer addUserByRequestTemplate(){
//        String url = "http://provider-service/user/add";
        String url = "http://127.0.0.1:8003/user/add";
        User user =new User();
        logger.info("sssssss");
        Integer result =  restTemplate.postForObject(url,user,Integer.class);
        Optional<Integer> optionalS = Optional.ofNullable(result);
        System.out.println(optionalS.orElse(0));
        return result;
    }


}
