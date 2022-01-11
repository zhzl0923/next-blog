package com.example.nextblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.nextblog.mapper")
public class NextBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(NextBlogApplication.class, args);
    }
}
