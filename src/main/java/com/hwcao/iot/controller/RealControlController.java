package com.hwcao.iot.controller;

import com.hwcao.iot.entity.Result;
import com.hwcao.iot.service.RealControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: iots_pringboot
 * @description:
 * @author: dyingstraw
 * @create: 2019-07-07 22:00
 **/
@RestController
@RequestMapping("/api/real")
public class RealControlController {
    @Autowired
    private RealControlService realControlService;

    /**
     * 取消监听
     * @return
     */
    @GetMapping("/cancel")
    public Object cancelReal(){
        return realControlService.cancelSubscribe();
    }

    /**
     * 开始监听
     * @return
     */
    @GetMapping("/start")
    public Object startReal(){
        return realControlService.startSubscribe();
    }
}
