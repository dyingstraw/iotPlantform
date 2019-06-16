package com.hwcao.iot.util;

import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: iots_pringboot
 * @description:通用工具类
 * @author: dyingstraw
 * @create: 2019-06-16 11:03
 **/
public class CommonUtil {
    private final static String HEADER_USER ="_userId";

    /**
     * 获得请求头的用户id
     * @return
     */
    public static Long getHeaderUserId(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = servletRequestAttributes.getRequest();
        return Long.valueOf(req.getHeader(HEADER_USER));
    }
}
