package com.itheima.day07;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.itheima.day07.mapper")
@EnableTransactionManagement
@ServletComponentScan
public class Day07Application {
    public static void main(String[] args) {
        SpringApplication.run(Day07Application.class, args);
    }
}
