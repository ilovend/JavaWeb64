package com.itheima.day03.test;

import com.itheima.day03.mapper.EmpMapper;
import com.itheima.day03.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * 用户测试
 *
 * @author ilovend
 * @date 2023/04/04
 */
@SpringBootTest
public class UserTest {
    @Autowired
    private EmpMapper empMapper;



    /**
     * 测试发现所有
     */
    @Test
    public void testFindAll() {
        List<Emp> emps = empMapper.selectList(null);
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }

    /**
     * 测试删除id
     */
    @Test
    public void testDeleteById() {
        empMapper.deleteById(1);
    }

}
