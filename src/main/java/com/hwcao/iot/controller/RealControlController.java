package com.hwcao.iot.controller;

import com.hwcao.iot.entity.Result;
import com.hwcao.iot.service.RealControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: iots_pringboot
 * @description:
 * @author: dyingstraw
 * @create: 2019-07-07 22:00
 **/
@RequestMapping("/api/real")
public class RealControlController {
    @Autowired
    private RealControlService realControlService;

    @GetMapping("/cancel")
    public Object cancelReal(){
        return realControlService.cancelSubscribe();
    }
    @GetMapping("/start")
    public Object startReal(){
        return realControlService.startSubscribe();
    }
}
