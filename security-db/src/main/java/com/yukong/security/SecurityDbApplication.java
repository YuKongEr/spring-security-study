package com.yukong.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yukong.security.mapper")
@SpringBootApplication
public class SecurityDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDbApplication.class, args);
    }
}
