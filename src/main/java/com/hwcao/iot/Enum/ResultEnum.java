package com.hwcao.iot.Enum;

import lombok.Getter;

@Getter
public enum ResultEnum {
    DEVICE_NOT_FIND(1,"设备不存在"),
    RECORD_ADD_ERROR(2,"记录插入错误"),
    RECORD_DEL_ERROR(3,"id删除记录错误"),
    USER_LOGIN_ERROR(403,"用户名或密码错误"),
    USER_REGISTER_ERROR(4,"注册信息不完整")

    ;

    private Integer code;

    private String message;


    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
