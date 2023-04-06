package com.itheima.day04.test;


import com.itheima.day04.service.DeptService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestDeptService {
    @Autowired
    DeptService deptService;

    @Test
    public void testDeptService(){
        deptService.getBaseMapper().selectList(null).forEach(System.out::println);
    }

}
