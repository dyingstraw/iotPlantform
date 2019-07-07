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
     * 获得请求头的用户id，在设备修改、添加等业务时，自动获取请求头的id
     * @return
     */
    public static Long getHeaderUserId(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(servletRequestAttributes == null){
            return 0L;
        }
        HttpServletRequest req = servletRequestAttributes.getRequest();

        return req.getHeader(HEADER_USER)== null ?0L:Long.valueOf(req.getHeader(HEADER_USER));
    }
}
