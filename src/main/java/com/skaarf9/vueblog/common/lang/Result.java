package com.skaarf9.vueblog.common.lang;/**
 * @author: Administrator
 * @date: 2022/2/22 17:40
 * @description:
 */

import lombok.Data;

/**
 * @author Administrator
 * @date 2022/2/22
 */
@Data
public class Result {
    private int code;
    private String msg;
    private Object data;

    /**
     * 成功返回码
     * @param data 返回数据
     * @return 封装的结果包
     */
    public static Result succ(Object data){
        Result result = new Result();
        result.setCode(200);
        result.setMsg("操作成功");
        result.setData(data);
        return result;
    }

    /**
     * 失败返回码
     * @param msg 返回数据
     * @return 封装的结果包
     */
    public static Result fail(String msg){
        Result result = new Result();
        result.setCode(400);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    /**
     * 失败返回码
     * @param data 返回数据
     * @param msg 返回消息
     * @return 封装的结果包
     */
    public static Result fail(String msg, Object data){
        Result result = new Result();
        result.setCode(400);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    /**
     * 失败返回码
     * @param data 返回数据
     * @param msg 返回消息
     * @param code 返回码
     * @return 封装的结果包
     */
    public static Result fail(int code, String msg, Object data){
        Result result = new Result();
        result.setMsg(msg);
        result.setCode(code);
        result.setData(data);
        return result;
    }

    /**
     * 成功返回码
     * @param data 返回数据
     * @param msg 返回消息
     * @return 封装的结果包
     */
    public static Result succ(String msg, Object data){
        Result result = new Result();
        result.setCode(200);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    /**
     * 成功返回码
     * @param data 返回数据
     * @param msg 返回消息
     * @return 封装的结果包
     */
    public static Result succ(int code, String msg, Object data){
        Result result = new Result();
        result.setCode(200);
        result.setMsg(msg);
        result.setData(data);
        result.setCode(code);
        return result;
    }
}
