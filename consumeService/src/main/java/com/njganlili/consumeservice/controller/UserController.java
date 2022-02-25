package com.njganlili.consumeservice.controller;

import com.njganlili.commonservice.model.User;
import com.njganlili.consumeservice.fegin.FeignClients;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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
@javax.annotation.Generated(value = "org.springdoc.demo.app2.codegen.languages.SpringCodegen", date = "2019-07-11T00:09:29.839+02:00[Europe/Paris]")

//@SecurityScheme(name = "petstore_auth", type = SecuritySchemeType.OAUTH2, flows = @OAuthFlows(implicit = @OAuthFlow(authorizationUrl = "https://petstore3.swagger.io/oauth/authorize", scopes = {
//        @OAuthScope(name = "write:pets", description = "modify pets in your account"),
//        @OAuthScope(name = "read:pets", description = "read your pets") })))

@RestController
@RequestMapping("/user")
@Tag(name = "放款申请Controller",description = "放款申请Controller")
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


    /**
     * 通过feign添加用户
     * @return
     */
    @Scheduled
    @GetMapping(value = "/addUser", consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" })
    @Operation(summary = "保存放款申请",description = "保存放款申请",method = "get")
    @ApiResponses(
            value ={
                    @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = User.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Order not found", content = @Content)
            }
    )
//    @RequestBody(
//            content = @Content(schema = @Schema(implementation = User.class))
//    )
    @Parameters(
            value = {
                    @Parameter(required = false,schema = @Schema(implementation = User.class))
            }
    )
    public Integer addUserByFeign(User user){
        Integer result = feignClients.addUser(user);
        logger.info(String.valueOf(result));
        return result;
    }

    /**
     * 通过restTemplate添加用户
     * @return
     */
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
