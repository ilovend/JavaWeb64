package com.itheima.day05.service;

import com.itheima.day05.pojo.Dept;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * idept服务
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author ilovend
 * @date 2023/04/07
 * @since 2023-04-07
 */
public interface IDeptService extends IService<Dept> {

    List<Dept> findAll();

    void deleteById(Integer id);

    void add(Dept dept);

    Dept findById(Integer id);

    void update(Dept dept);
}
