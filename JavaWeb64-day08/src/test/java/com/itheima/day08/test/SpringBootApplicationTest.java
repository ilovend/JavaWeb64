package com.itheima.day08.test;

import com.example.HeaderGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringBootApplicationTest {

    @Autowired
    private HeaderGenerator headerGenerator;

    @Test
    public void testItheimaUtils() {
        System.out.println(headerGenerator);
    }
}
