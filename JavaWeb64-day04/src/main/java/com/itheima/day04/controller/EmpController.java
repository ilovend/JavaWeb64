package com.itheima.day04.controller;


import com.itheima.day04.common.MsgConstant;
import com.itheima.day04.common.PageBean;
import com.itheima.day04.common.Result;
import com.itheima.day04.pojo.Emp;
import com.itheima.day04.service.EmpService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author ilovend
 * @date 2023/04/06
 * @since 2023-04-06
 */
@RestController
@RequestMapping("/emps")
@Api(tags = "员工管理")
public class EmpController {
    /**
     * empService
     */
    @Autowired
    private EmpService empService;

    /**
     * 分页查询
     *
     * @param page     页面
     * @param pageSize 页面大小
     * @param name     名字
     * @param gender   性别
     * @param begin    开始
     * @param end      结束
     * @return {@link Result}
     */
    @GetMapping
    public Result pageList(Integer page, Integer pageSize, String name, Short gender, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin, @DateTimeFormat(pattern = "yyyy-MM-dd")  LocalDate end) {
        PageBean pageBean = null;
        try {
            pageBean = empService.pageList(page, pageSize, name, gender, begin, end);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(MsgConstant.QUERY_ERROR);
        }
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result deleteById(@PathVariable("ids") List<Integer> ids) {
        try {
            empService.deleteById(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(MsgConstant.DELETE_ERROR);
        }
        return Result.success();
    }

}