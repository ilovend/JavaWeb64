package com.itheima.day03.service.impl;

import com.itheima.day03.pojo.Emp;
import com.itheima.day03.mapper.EmpMapper;
import com.itheima.day03.service.IEmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author ilovend
 * @since 2023-04-04
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {

}
