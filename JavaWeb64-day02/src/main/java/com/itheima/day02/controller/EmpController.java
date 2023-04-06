package com.itheima.day02.controller;


import com.itheima.day02.common.Result;
import com.itheima.day02.pojo.Emp;
import com.itheima.day02.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * 增删查改
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

    /*
     * 查询所有员工
     * */

    @GetMapping("/list")
    public Result list() {
        return Result.ok(empService.list());
    }

    /*
     * 查询一个员工
     * */

    @GetMapping("/findById")
    public Result findById(Integer empno) {
        return Result.ok(empService.getById(empno));
    }

    /*
     * 添加一个员工
     * */

    @GetMapping("/add")
    public Result add(Emp emp) {
        return Result.ok(empService.save(emp));
    }

    /*
     * 修改一个员工
     * */

    @GetMapping("/update")
    public Result update(Emp emp) {
        return Result.ok(empService.updateById(emp));
    }

    /*
     * 删除一个员工
     * */

    @GetMapping("/delete")
    public Result delete(Integer id) {
        return Result.ok(empService.removeById(id));
    }

}
