package com.itheima.day01.service.impl;

import com.itheima.day01.mapper.EmpMapper;
import com.itheima.day01.pojos.Emp;
import com.itheima.day01.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Emp> listEmp() {

        return empMapper.listEmp();
    }
}
