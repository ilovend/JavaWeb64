package com.itheima.day03.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 员工表
 * </p>
 *
 * @author ilovend
 * @since 2023-04-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("emp")
@ApiModel(value="Emp对象", description="员工表")
public class Emp implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "性别, 说明: 1 男, 2 女")
    @TableField("gender")
    private Integer gender;

    @ApiModelProperty(value = "图像")
    @TableField("image")
    private String image;

    @ApiModelProperty(value = "职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师")
    @TableField("job")
    private Integer job;

    @ApiModelProperty(value = "入职时间")
    @TableField("entrydate")
    private LocalDate entrydate;

    @ApiModelProperty(value = "部门ID")
    @TableField("dept_id")
    private Integer deptId;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("update_time")
    private LocalDateTime updateTime;


}
