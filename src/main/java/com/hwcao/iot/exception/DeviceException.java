package com.hwcao.iot.exception;

import com.hwcao.iot.Enum.ResultEnum;
import lombok.Getter;

@Getter
public class DeviceException extends RuntimeException {

    private Integer code;

    public DeviceException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public DeviceException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

}
