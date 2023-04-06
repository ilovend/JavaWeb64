package com.itheima.day04;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.itheima.day04.mapper")
@EnableTransactionManagement
@Slf4j
public class Day04Application {
    public static void main(String[] args) {
        SpringApplication.run(Day04Application.class, args);
        log.info("项目启动成功.....");
    }
}
