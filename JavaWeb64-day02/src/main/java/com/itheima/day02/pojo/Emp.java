package com.itheima.day02.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author ilovend
 * @since 2023-04-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("emp")
public class Emp implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "EMPNO")
    private Long empno;

    @TableField("ENAME")
    private String ename;

    @TableField("JOB")
    private String job;

    @TableField("MGR")
    private Long mgr;

    @TableField("HIREDATE")
    private LocalDate hiredate;

    @TableField("SAL")
    private Double sal;

    @TableField("COMM")
    private Double comm;

    @TableField("DEPTNO")
    private Long deptno;


}
