package com.itheima.day05.mapper;

import com.itheima.day05.pojo.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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
