package com.itheima.day04.controller;


import com.itheima.day04.common.MsgConstant;
import com.itheima.day04.common.Result;
import com.itheima.day04.pojo.Dept;
import com.itheima.day04.service.DeptService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 部门控制器
 * </p>
 *
 * @author ilovend
 * @date 2023/04/06
 * @since 2023-04-06
 */
@RestController
@RequestMapping("/depts")
@Api(tags = "部门管理")
public class DeptController {
    /**
     * deptService
     */
    @Autowired
    private DeptService deptService;

    /**
     * 查找所有
     *
     * @return {@link Result}
     */
    @GetMapping
    public Result findAll() {
        List<Dept> depts = null;
        try {
            depts = deptService.getBaseMapper().selectList(null);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(MsgConstant.FAIL);
        }
        return Result.success(depts);
    }

    /**
     * 删除通过id
     *
     * @param id id
     * @return {@link Result}
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable("id") Integer id) {
        try {
            deptService.getBaseMapper().deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(MsgConstant.FAIL);
        }
        return Result.success(MsgConstant.SUCCESS);
    }


    /**
     * 添加
     *
     * @param dept 部门
     * @return {@link Result}
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        try {
            deptService.getBaseMapper().insert(dept);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }

        return Result.success(MsgConstant.SUCCESS);
    }
}
