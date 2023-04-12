package com.itheima.day07.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.day07.common.PageBean;
import com.itheima.day07.pojo.Emp;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * <p>
 * 员工表 服务类
 * </p>
 *
 * @author ilovend
 * @since 2023-04-07
 */

public interface IEmpService extends IService<Emp> {

    PageBean page(String name, Short gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize);


    void deleteByIds(ArrayList ids);

    void add(Emp emp);

    Emp findById(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);

}
