package com.itheima.day01.mapper.impl;

import com.itheima.day01.common.XmlParserUtils;
import com.itheima.day01.mapper.EmpMapper;
import com.itheima.day01.pojos.Emp;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmpMapperImpl implements EmpMapper {
    @Override
    public List<Emp> listEmp() {
        String file = ClassLoader.getSystemClassLoader().getResource("emp.xml").getFile();

        return XmlParserUtils.parse(file, Emp.class);
    }
}
