package com.itheima.day02.service.impl;

import com.itheima.day02.pojo.Dept;
import com.itheima.day02.mapper.DeptMapper;
import com.itheima.day02.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ilovend
 * @since 2023-04-01
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

}
