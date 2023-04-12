package com.itheima.day06;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.itheima.day06.mapper")
@EnableTransactionManagement
@ServletComponentScan
public class Day06Application {
    public static void main(String[] args) {
        SpringApplication.run(Day06Application.class, args);
    }
}
