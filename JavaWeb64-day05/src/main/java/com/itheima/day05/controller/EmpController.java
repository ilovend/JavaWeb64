package com.itheima.day05.controller;


import com.itheima.day05.common.MsgConstant;
import com.itheima.day05.common.PageBean;
import com.itheima.day05.common.Result;
import com.itheima.day05.pojo.Emp;
import com.itheima.day05.service.IEmpService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author ilovend
 * @date 2023/04/08
 */
@RestController
@RequestMapping("/emps")
@Api(tags = "员工管理")
public class EmpController {
    /**
     * empService
     */
    @Autowired
    private IEmpService iEmpService;

    /**
     * 请求路径：/emps<br/>
     * 请求方式：GET<br/>
     * 接口描述：该接口用于员工列表数据的条件分页查询<br/>
     *
     * @param name     名字
     * @param gender   性别
     * @param begin    开始日期
     * @param end      结束日期
     * @param page     第几页
     * @param pageSize 分页条数
     * @return {@link Result}
     */
    @GetMapping
    public Result page(String name, Short gender, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end, Integer page, Integer pageSize) {
        PageBean pageBean = null;
        try {
            pageBean = iEmpService.page(name, gender, begin, end, page, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(MsgConstant.QUERY_ERROR);
        }
        return Result.success(pageBean);
    }

    /**
     * 请求路径：/emps/{ids}<br/>
     * 请求方式：DELETE<br/>
     * 请求参数：路径参数 {ids}<br/>
     * 响应数据：json格式<br/>
     *
     * @param ids 用户id
     * @return {@link Result}
     */
    @DeleteMapping("/{ids}")
    public Result deleteByIds(@PathVariable ArrayList ids) {
        try {
            iEmpService.deleteByIds(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(MsgConstant.DELETE_ERROR);
        }
        return Result.success();
    }

    /**
     * 请求路径：/emps/{ids}<br/>
     * 请求方式：DELETE<br/>
     * 接口描述：该接口用于批量删除员工的数据信息<br/>
     *
     * @param emp 员工对象
     * @return {@link Result}
     */
    @PostMapping
    public Result add(@RequestBody Emp emp) {
        try {
            iEmpService.add(emp);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(MsgConstant.ADD_ERROR);
        }
        return Result.success();
    }

    /**
     * 请求路径：/emps/{id}<br/>
     * 请求方式：GET<br/>
     * 接口描述：该接口用于根据主键ID查询员工的信息<br/>
     *
     * @param id 用户id
     * @return {@link Result}
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        Emp emp= null;
        try {
            emp = iEmpService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(MsgConstant.QUERY_ERROR);
        }
        return Result.success(emp);
    }

    /**
     * 请求路径：/emps<br/>
     * 请求方式：PUT<br/>
     * 接口描述：该接口用于修改员工的数据信息<br/>
     *
     * @param emp 员工对象
     * @return {@link Result}
     */
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        try {
            iEmpService.update(emp);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(MsgConstant.UPDATE_ERROR);
        }
        return Result.success();
    }
}
