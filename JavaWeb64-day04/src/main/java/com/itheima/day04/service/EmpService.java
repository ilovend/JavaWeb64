package com.itheima.day04.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.day04.common.PageBean;
import com.itheima.day04.pojo.Emp;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 员工表 服务类
 * </p>
 *
 * @author ilovend
 * @since 2023-04-06
 */
public interface EmpService extends IService<Emp> {

    PageBean pageList(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void deleteById(List<Integer> ids);
}
