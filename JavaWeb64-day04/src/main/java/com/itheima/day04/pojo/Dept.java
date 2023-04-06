package com.itheima.day04.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 部门实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name; //部门名称

    @TableField(fill = FieldFill.INSERT)
    private LocalDate createTime; //创建时间

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDate updateTime; //修改时间
}
