package com.hwcao.iot.controller;

import com.hwcao.iot.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: iots_pringboot
 * @description:
 * @author: dyingstraw
 * @create: 2019-06-12 20:48
 **/
@RestController
public class BaseController {

    @RequestMapping("/")
    public Object sayHello(Integer num) throws Exception {

        return null;
    }

}
