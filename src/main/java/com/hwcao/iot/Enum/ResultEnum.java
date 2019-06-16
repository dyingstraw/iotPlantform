package com.hwcao.iot.Enum;

import lombok.Getter;

@Getter
public enum ResultEnum {
    DEVICE_NOT_FIND(1,"设备不存在")
    ;

    private Integer code;

    private String message;


    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
