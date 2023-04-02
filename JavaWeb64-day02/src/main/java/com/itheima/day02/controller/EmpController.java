package com.itheima.day02.controller;


import com.itheima.day02.common.Result;
import com.itheima.day02.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ilovend
 * @since 2023-04-01
 */
@RestController
@RequestMapping("/emp")

public class EmpController {
    @Autowired
    private IEmpService empService;

    @GetMapping("/list")
    public Result list(){
        return Result.ok(empService.list());
    }

}
