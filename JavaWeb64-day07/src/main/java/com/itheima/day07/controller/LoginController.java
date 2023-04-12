package com.itheima.day07.controller;

import com.itheima.day07.common.Result;
import com.itheima.day07.pojo.Emp;
import com.itheima.day07.service.IEmpService;
import com.itheima.day07.utils.JwtUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 登录控制器
 *
 * @author ilovend
 * @date 2023/04/10
 */
@RestController
@RequestMapping
@Api(tags = "登录控制器")
public class LoginController {
    /**
     * empService
     */
    @Autowired
    private IEmpService empService;

    /**
     * 登录
     *
     * @param emp emp员工对象
     * @return {@link Result}
     */
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
