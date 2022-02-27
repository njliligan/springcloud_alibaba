package com.njganlili.consumeservice.controller;
import java.util.Date;

import com.njganlili.commonservice.entity.User;
import com.njganlili.interfaces.provider.service.UserService;
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

import java.util.Optional;

/**
 * @author njgan
 * @description
 * @date 2022/2/21 15:59
 */
@javax.annotation.Generated(value = "org.springdoc.demo.app2.codegen.languages.SpringCodegen", date = "2019-07-11T00:09:29.839+02:00[Europe/Paris]")

//@SecurityScheme(name = "petstore_auth", type = SecuritySchemeType.OAUTH2, flows = @OAuthFlows(implicit = @OAuthFlow(authorizationUrl = "https://petstore3.swagger.io/oauth/authorize", scopes = {
//        @OAuthScope(name = "write:pets", description = "modify pets in your account"),
//        @OAuthScope(name = "read:pets", description = "read your pets") })))

@RestController
@RequestMapping("/user")
@Tag(name = "UserController",description = "用户操作")
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

//    @Autowired
//    private RestTemplate restTemplate;

    @DubboReference
    private UserService userService;

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
//    @Parameters(
//            value = {
//                    @Parameter(required = false,schema = @Schema(implementation = User.class))
//            }
//    )
    @PostMapping(value = "/addUser", consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" })
    public Integer addUserByFeign(@RequestBody User user){
//        Integer result = feignClients.addUser(user);
        Integer result = userService.addUser(user);
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
        user.setCreatedTime(new Date());
        user.setUpdatedBy("miky");
        user.setUpdatedTime(new Date());
        user.setId("1");

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
