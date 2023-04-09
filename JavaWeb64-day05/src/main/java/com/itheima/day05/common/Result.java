package com.itheima.day05.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回结果类
 *
 * @author ilovend
 * @date 2023/04/07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    /**
     * 响应码<br/>
     * 1 代表成功<br/>
     * 0 代表失败<br/>
     */
    private Integer code;//响应码，1 代表成功; 0 代表失败
    /**
     * 响应信息<br/>
     * 描述字符串<br/>
     */
    private String msg;  //响应信息 描述字符串
    /**
     * 返回的数据<br/>
     */
    private Object data; //返回的数据

    /**
     * 增删改 成功响应
     *
     * @return {@link Result}
     */
    public static Result success(){
        return new Result(1,"success",null);
    }

    /**
     * 查询 成功响应
     *
     * @param data 数据
     * @return {@link Result}
     */
    public static Result success(Object data){
        return new Result(1,"success",data);
    }

    /**
     * 失败响应
     *
     * @param msg 信息
     * @return {@link Result}
     */
    public static Result error(String msg){
        return new Result(0,msg,null);
    }
}
