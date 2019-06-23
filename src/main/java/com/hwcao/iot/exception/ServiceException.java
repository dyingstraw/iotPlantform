package com.hwcao.iot.exception;

import com.hwcao.iot.Enum.ResultEnum;

public class ServiceException extends RuntimeException {
    private Integer code;

    public ServiceException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
