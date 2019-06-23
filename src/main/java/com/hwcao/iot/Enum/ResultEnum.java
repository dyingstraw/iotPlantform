package com.hwcao.iot.Enum;

import lombok.Getter;

@Getter
public enum ResultEnum {
    DEVICE_NOT_FIND(1,"设备不存在"),
    RECORD_ADD_ERROR(2,"记录插入错误"),
    RECORD_DEL_ERROR(3,"id删除记录错误")

    ;

    private Integer code;

    private String message;


    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
