package com.itheima.day06.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * PageBean<br/>
 * 后台给前端返回的数据包含：List集合(数据列表)、total(总记录数)
 * 而这两部分我们通常封装到PageBean对象中，并将该对象转换为json格式的数据响应回给浏览器。
 * @author ilovend
 * @date 2023/04/08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private Long total; //总记录数
    private List rows; //当前页数据列表
}