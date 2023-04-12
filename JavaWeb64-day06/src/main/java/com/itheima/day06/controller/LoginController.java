package com.itheima.day06.controller;

import com.itheima.day06.common.Result;
import com.itheima.day06.pojo.Emp;
import com.itheima.day06.service.IEmpService;
import com.itheima.day06.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping
public class LoginController {
    @Autowired
    private IEmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
       Emp e= empService.login(emp);
        if (e != null) {
            HashMap<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("username", e.getUsername());
            claims.put("name", e.getName());

            String token = JwtUtils.generateJwt(claims);
            return Result.success(token);
        }
        return Result.error("用户名或者密码错误");
    }
}
