package com.itheima.day02;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itheima.day02.mapper")
public class Day02Application {
    public static void main(String[] args) {
        SpringApplication.run(Day02Application.class, args);
    }
}
