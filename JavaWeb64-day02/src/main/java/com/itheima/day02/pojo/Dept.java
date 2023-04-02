package com.itheima.day02.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
@TableName("dept")
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "DEPTNO")
    private Long deptno;

    @TableField("DNAME")
    private String dname;

    @TableField("LOC")
    private String loc;


}
