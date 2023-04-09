package com.itheima.day05;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itheima.day05.mapper")
public class Day05Application {
    public static void main(String[] args) {
        SpringApplication.run(Day05Application.class, args);
    }
}
