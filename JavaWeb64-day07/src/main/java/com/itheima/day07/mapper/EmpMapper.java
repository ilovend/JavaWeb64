package com.itheima.day07.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.day07.pojo.Emp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 员工表 Mapper 接口
 * </p>
 *
 * @author ilovend
 * @since 2023-04-07
 */
public interface EmpMapper extends BaseMapper<Emp> {

    List<Emp> page(String name, Short gender, LocalDate begin, LocalDate end, Integer index, Integer pageSize);

    Long countPage(String name, Short gender, LocalDate begin, LocalDate end);

    void deleteByIds(ArrayList ids);

    void add(Emp emp);

    Emp findById(Integer id);

    void update(Emp emp);

    Emp findByUsername(Emp emp);

    void deleteByDeptId(Integer id);
}
