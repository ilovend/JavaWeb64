package com.itheima.day07.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.day07.anno.Log;
import com.itheima.day07.mapper.DeptLogMapper;
import com.itheima.day07.mapper.DeptMapper;
import com.itheima.day07.mapper.EmpMapper;
import com.itheima.day07.pojo.Dept;
import com.itheima.day07.pojo.DeptLog;
import com.itheima.day07.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author ilovend
 * @since 2023-04-07
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptLogMapper deptLogMapper;


    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Log
    public void deleteById(Integer id) throws Exception {
        try {
            deptMapper.deleteById(id);
//        同时删除部门下的员工
            if (true) {
                throw new Exception("出现了异常");
            }
            empMapper.deleteByDeptId(id);
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作，此时解散的是" + id + "号部门");
            deptLogMapper.insert(deptLog);
        }

    }

    @Override
    @Log
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }

    @Override
    public Dept findById(Integer id) {
        return deptMapper.findById(id);
    }

    @Override
    @Log
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }


}
