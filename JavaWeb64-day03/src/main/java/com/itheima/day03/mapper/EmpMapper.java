package com.itheima.day03.mapper;

import com.itheima.day03.pojo.Emp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 员工表 Mapper 接口
 * </p>
 *
 * @author ilovend
 * @since 2023-04-04
 */
public interface EmpMapper extends BaseMapper<Emp> {

    List<Emp> findAll();

    Emp findById(Integer id);

    void deleteById(Integer id);

    int updateById(Emp emp);



}
