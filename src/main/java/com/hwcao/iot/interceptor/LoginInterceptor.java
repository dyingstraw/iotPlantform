package com.hwcao.iot.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.hwcao.iot.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求拦截，一请求就来这了。
 */

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        log.info("session id"+request.getSession().toString());
//        log.info("header"+request.getHeader("_userId"));
        /**
         * 拦截器：
         * 如果请求中带session()，则放行
         * 如果请求不带session()，则跳转登陆
         */
        if(request.getSession().getAttribute("userName")==null){
            response.getOutputStream().print(JSONObject.toJSONString(Result.FAILED(1,"to login")));
            response.flushBuffer();
            return false;
        }else {
              return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
