package com.itheima.day04.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.day04.mapper.DeptMapper;
import com.itheima.day04.pojo.Dept;
import com.itheima.day04.service.DeptService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author ilovend
 * @since 2023-04-06
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

}
