package com.itheima.day05.controller;


import com.itheima.day05.common.MsgConstant;
import com.itheima.day05.common.Result;
import com.itheima.day05.pojo.Dept;
import com.itheima.day05.service.IDeptService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 部门列表查询<br/>
 * </p>
 *
 * @author ilovend
 * @since 2023-04-07
 */
@RestController
@RequestMapping("/depts")
@Api(tags = "部门管理")
@Slf4j
public class DeptController {
    /**
     * 部门服务接口<br/>
     */
    @Autowired
    private IDeptService iDeptService;

    /**
     * 请求路径：/depts<br/>
     * 请求方式：GET<br/>
     * 接口描述：该接口用于部门列表数据查询<br/>
     *
     * @return {@link Result}
     */
    @GetMapping
    public Result findAll() {
        List<Dept> deptList = null;
        try {
            deptList = iDeptService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(MsgConstant.QUERY_ERROR);
        }
        log.info("deptList:{}", deptList);
        return Result.success(deptList);
    }

    /**
     * 请求路径：/depts/{id}<br/>
     * 请求方式：DELETE<br/>
     * 接口描述：该接口用于根据ID删除部门数据<br/>
     *
     * @param id id
     * @return {@link Result}
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        try {
            iDeptService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(MsgConstant.DELETE_ERROR);
        }
        return Result.success();

    }

    /**
     * 请求路径：/depts<br/>
     * 请求方式：POST<br/>
     * 接口描述：该接口用于添加部门数据<br/>
     *
     * @param dept 部门
     * @return {@link Result}
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        try {
            iDeptService.add(dept);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(MsgConstant.ADD_ERROR);
        }
        return Result.success();
    }

    /**
     * 请求路径：/depts/{id}<br/>
     * 请求方式：GET<br/>
     * 接口描述：该接口用于根据ID查询部门数据<br/>
     *
     * @param id id
     * @return {@link Result}
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        Dept dept = null;
        try {
            dept = iDeptService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(MsgConstant.QUERY_ERROR);
        }
        return Result.success(dept);
    }

    /**
     * 请求路径：/depts<br/>
     * 请求方式：PUT<br/>
     * 接口描述：该接口用于修改部门数据<br/>
     *
     * @param dept 部门
     * @return {@link Result}
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        try {
            iDeptService.update(dept);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(MsgConstant.UPDATE_ERROR);
        }
        return Result.success();
    }

}
