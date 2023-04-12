package com.itheima.day06.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.day06.pojo.Dept;

import java.util.List;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author ilovend
 * @since 2023-04-07
 */
public interface DeptMapper extends BaseMapper<Dept> {

    List<Dept> findAll();

    void deleteById(Integer id);

    void add(Dept dept);

    Dept findById(Integer id);

    void update(Dept dept);
}
