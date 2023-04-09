package com.itheima.day05.test;

import com.itheima.day05.mapper.DeptMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeptMapperTest {
    @Autowired
    private DeptMapper deptMapper;

    @Test
    public void findAll() {
        deptMapper.findAll();
    }

}
