package com.yukong.security.service.impl;

import com.yukong.security.entity.User;
import com.yukong.security.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void loadUserByUsername() {

        System.out.println(userService.loadUserByUsername("admin"));
    }

    @Test
    public void register(){
        User user = new User();
        user.setUsername("yukong")
                .setPassword("password")
                .setNickname("yukong")
                .setRoles("ADMIN");
        userService.register(user);
    }
}