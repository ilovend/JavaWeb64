package com.itheima.day04.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.day04.pojo.Emp;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 员工表 Mapper 接口
 * </p>
 *
 * @author ilovend
 * @since 2023-04-06
 */
public interface EmpMapper extends BaseMapper<Emp> {

    Long setCount(String name, Short gender, LocalDate begin, LocalDate end);

    List<Emp> setPage(Integer index, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void deleteById(List<Integer> ids);

}
