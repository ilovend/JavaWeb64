package com.itheima.day02.common;
/*
* 更好的封装返回结果类
* 包含状态码，状态信息，数据
* */
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public Result() {
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result ok(Object data){
        return new Result(200,"ok",data);
    }

    public static Result ok(){
        return new Result(200,"ok",null);
    }

    public static Result error(String msg){
        return new Result(500,msg,null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
