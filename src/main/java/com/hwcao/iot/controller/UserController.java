package com.hwcao.iot.controller;

import com.hwcao.iot.dao.user.UserDao;
import com.hwcao.iot.entity.Result;
import com.hwcao.iot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: iots_pringboot
 * @description:
 * @author: dyingstraw
 * @create: 2019-06-12 20:07
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;

    @GetMapping("/name")
    public Result getUserByName(@RequestParam("name") String name) {
        return Result.SUCCESS(userService.getUserByName(name));
    }

    // @GetMapping("/valid")
    // public Result validUser(String username,String password){
    //     return Result.SUCCESS(userDao.checkUser(username,password));
    // }
}
