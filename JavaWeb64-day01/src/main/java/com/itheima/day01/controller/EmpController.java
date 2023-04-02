package com.itheima.day01.controller;


import com.itheima.day01.common.Result;
import com.itheima.day01.pojos.Emp;
import com.itheima.day01.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping("listEmp")
    public Result listEmp() {
        List<Emp> listEmp = null;
        try {
            listEmp = empService.listEmp();
        } catch (Exception e) {
            Result.error("0");
        }
        return Result.success(listEmp);
    }
}
