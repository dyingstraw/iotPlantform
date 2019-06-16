package com.hwcao.iot.exception;

/**
 * @program: iots_pringboot
 * @description: 定制异常
 * @author: dyingstraw
 * @create: 2019-06-16 10:55
 **/
public class CustomException extends Exception{
    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    public CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
