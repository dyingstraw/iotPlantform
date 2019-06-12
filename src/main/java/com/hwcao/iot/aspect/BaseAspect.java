package com.hwcao.iot.aspect;

import com.hwcao.iot.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

/**
 * @program: iots_pringboot
 * @description:
 * @author: dyingstraw
 * @create: 2019-06-12 20:58
 **/
@Aspect
@Slf4j
@Component
public class BaseAspect {
    @Pointcut("execution(public * com.hwcao.iot.controller.*.*(..))")
    public void controller(){
    }

    @Around("controller()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("------------------aspect before----------------");
        String name = joinPoint.getSignature().getDeclaringTypeName();
        Result r = (Result)joinPoint.proceed(joinPoint.getArgs());
        r.setSid(UUID.randomUUID().toString());
        log.info(name+" : " + joinPoint.getSignature().getName()+"("+ Arrays.toString(joinPoint.getArgs())+")");
        log.info("------------------aspect  after----------------");

        return r;

    }


}
