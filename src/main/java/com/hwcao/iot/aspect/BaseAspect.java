package com.hwcao.iot.aspect;

import com.hwcao.iot.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
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
        try{
            Result r = (Result)joinPoint.proceed(joinPoint.getArgs());
            r.setSid(UUID.randomUUID().toString());
            log.info(name+" : " + joinPoint.getSignature().getName()+"("+ Arrays.toString(joinPoint.getArgs())+")");
            return r;
        }catch (Exception e){
            e.printStackTrace();
            Result<Object> r = Result.FAILED(400, e.getMessage());
            r.setSid(UUID.randomUUID().toString());
            return r;
        }finally {
            log.info("------------------aspect  after----------------");
        }
    }
    // @AfterThrowing(value = "controller()",throwing = "ex")
    // public void doThrow(JoinPoint joinPoint,Throwable ex){
    //     log.info("hellllllllllllllll");
    //     Result<Object> r = Result.FAILED(400, "ssssssssssssssssssssss");
    //
    // }


}
