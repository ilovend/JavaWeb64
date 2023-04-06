package com.itheima.day04.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.day04.common.PageBean;
import com.itheima.day04.mapper.EmpMapper;
import com.itheima.day04.pojo.Emp;
import com.itheima.day04.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author ilovend
 * @since 2023-04-06
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean pageList(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //1.查询总记录数
        Long total = empMapper.setCount(name, gender, begin, end);
        //2.查询当前页的数据
        Integer index = (page - 1) * pageSize;
        List<Emp> empList = empMapper.setPage(index, pageSize, name, gender, begin, end);
        //3.封装PageBean
        return new PageBean(total, empList);
    }

    @Override
    public void deleteById(List<Integer> ids) {
        empMapper.deleteById(ids);
    }
}
