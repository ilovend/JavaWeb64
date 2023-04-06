package com.itheima.day03.service.impl;

import com.itheima.day03.pojo.Dept;
import com.itheima.day03.mapper.DeptMapper;
import com.itheima.day03.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author ilovend
 * @since 2023-04-04
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

}
