package com.itheima.day06.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.day06.common.PageBean;
import com.itheima.day06.mapper.EmpMapper;
import com.itheima.day06.pojo.Emp;
import com.itheima.day06.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author ilovend
 * @since 2023-04-07
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {
    @Autowired
    EmpMapper empMapper;

    @Override
    public PageBean page(String name, Short gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
//        1.查询下标
        Integer index = (page - 1) * pageSize;
//        2.查询页内容
        List<Emp> empList= empMapper.page(name, gender, begin, end, index, pageSize);
//        3.查询总记录数
       Long pageCount= empMapper.countPage(name, gender, begin, end);
//       包装pageBean
        return new PageBean(pageCount,empList);
    }

    @Override
    public void deleteByIds(ArrayList ids) {
        empMapper.deleteByIds(ids);
    }

    @Override
    public void add(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.add(emp);
    }

    @Override
    public Emp findById(Integer id) {
        return empMapper.findById(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.findByUsername(emp);
    }



}
