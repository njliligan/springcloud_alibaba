package com.njganlili.providerservice.task;

import com.njganlili.commonservice.entity.User;
import com.njganlili.providerservice.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author njgan
 * @description
 * @date 2022/3/24 20:56
 */
@Component
public class UserDataInitializer implements CommandLineRunner {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public void run(String... args) throws Exception {
        Random random = new Random();
        for (int i =0; i < 10000; i++) {
            int a = (random.nextInt() % 2);
            System.out.println(i);
            User user = new User(
                    String.valueOf(i),
                    "miky-" + i,
                    10 + Math.abs((random.nextInt() % 15)),
                    Integer.toString(Math.abs(a)),
                    "511011199809"+String.format("%2d", random.nextInt(30) + 1) +String.format("%4d", i),
                    null,
                    "0",
                    LocalDateTime.now(),
                    "null",
                    LocalDateTime.now()
                    );

            userService.addUser(user);
        }
    }

}
