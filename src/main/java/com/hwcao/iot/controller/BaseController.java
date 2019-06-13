package com.hwcao.iot.controller;

import com.hwcao.iot.entity.Result;
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

        if (num.equals(1)){
            throw new Exception("hello exection");
        }else {
            return Result.SUCCESS();
        }
    }


}
