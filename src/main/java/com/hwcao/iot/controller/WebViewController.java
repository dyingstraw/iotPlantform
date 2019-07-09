package com.hwcao.iot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: iots_pringboot
 * @description: 网页显示
 * @author: dyingstraw
 * @create: 2019-07-09 14:20
 **/
@Controller
@RequestMapping("/webview/{path}")
public class WebViewController {
    @RequestMapping("")
    public String index(@PathVariable("path") String path){
        return path;
    }

}
