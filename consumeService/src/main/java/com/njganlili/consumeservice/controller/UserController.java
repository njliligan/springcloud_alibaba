package com.njganlili.consumeservice.controller;
import java.time.LocalDateTime;

import com.njganlili.commonservice.entity.User;
import com.njganlili.commonservice.util.SnowFlakeService;
import com.njganlili.interfaces.provider.service.UserService;
import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

/**
 * @author njgan
 * @description
 * @date 2022/2/21 15:59
 */
@javax.annotation.Generated(value = "org.springdoc.demo.app2.codegen.languages.SpringCodegen", date = "2019-07-11T00:09:29.839+02:00[Europe/Paris]")
@RestController
@RequestMapping("/user")
@Tag(name = "UserController",description = "用户操作")
public class UserController {

    public static  int a =0;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @DubboReference
    private UserService userService;

    private SnowFlakeService snowFlakeService;

    /**
     * 通过feign添加用户
     * @return
     */
    @Operation(summary = "通过feign添加用户",description = "通过feign添加用户")
    @ApiResponses(
            value ={
                    @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = User.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Order not found", content = @Content)
            }
    )

    @PostMapping(value = "/addUser", consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" })
    @GlobalTransactional
    public Integer addUserByFeign(@RequestBody User user){
        user.setUserName("miky");
        user.setUserAge(0);
        user.setUserSex("MAN");
        user.setUserIdCard("111111111111");
        user.setRevision("2");
        user.setCreatedBy("miky");
        user.setCreatedTime(LocalDateTime.now());
        user.setUpdatedBy("miky");
        user.setUpdatedTime(LocalDateTime.now());
        user.setId(String.valueOf(snowFlakeService.getNextId()));
        Integer result = userService.addUser(user);
        if (Math.random() > 0.5){
            throw new RuntimeException();
        }else {
            System.out.println(++a);
        }
        logger.info(String.valueOf(result));
        return result;
    }

    /**
     * 通过restTemplate添加用户
     * @return
     */
    @Operation(summary = "通过restTemplate添加用户",description = "通过restTemplate添加用户")
    @GetMapping("/addUserByRestTemplate")
    public Integer addUserByRequestTemplate(){
//        String url = "http://provider-service/user/add";
        String url = "http://127.0.0.1:8003/user/add";
        User user =new User();
        user.setUserName("miky");
        user.setUserAge(0);
        user.setUserSex("MAN");
        user.setUserIdCard("111111111111");
        user.setRevision("2");
        user.setCreatedBy("miky");
//        user.setCreatedTime(LocalDateTime.now());
        user.setUpdatedBy("miky");
//        user.setUpdatedTime(LocalDateTime.now());
        user.setId(Integer.getInteger(String.valueOf(Math.random()*(1000))).toString());

        logger.info("sssssss");
//        Integer result =  restTemplate.postForObject(url,user,Integer.class);
        Integer result = Integer.valueOf(10);
        Optional<Integer> optionalS = Optional.ofNullable(result);
        System.out.println(optionalS.orElse(0));
        if (optionalS.isPresent()){
            throw new RuntimeException();
        }
        return result;
    }


}
