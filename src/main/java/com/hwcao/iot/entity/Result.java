package com.hwcao.iot.entity;

import lombok.Data;

/**
 * @program: iots_pringboot
 * @description:
 * @author: dyingstraw
 * @create: 2019-06-12 20:49
 **/
@Data
public class Result <T>{
    private Integer code;
    private String message;
    private Boolean success;
    private String sid;
    private T data;

    public Result(Integer code, String message, Boolean success, T data) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public static <T>Result SUCCESS(){
        Result<T> result = new Result<>(200, "success", true, null);
        return result;
    }
    public static <T>Result SUCCESS(T data){
        Result<T> result = new Result<>(200, "success", true, data);
        return result;
    }
    public static <T>Result<T> FAILED(Integer code,String message){
        Result<T> result = new Result<>(code, message, false, null);
        return result;
    }
}
