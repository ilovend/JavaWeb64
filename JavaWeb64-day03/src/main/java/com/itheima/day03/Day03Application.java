package com.itheima.day03;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itheima.day03.mapper")
public class Day03Application {
    public static void main(String[] args) {
        SpringApplication.run(Day03Application.class, args);
    }
}
