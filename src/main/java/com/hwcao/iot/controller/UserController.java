package com.hwcao.iot.controller;

import com.hwcao.iot.dao.user.UserDao;
import com.hwcao.iot.dto.User.UserReqDTO;
import com.hwcao.iot.dto.User.UserRespDTO;
import com.hwcao.iot.entity.Result;
import com.hwcao.iot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @program: iots_pringboot
 * @description:
 * @author: dyingstraw
 * @create: 2019-06-12 20:07
 **/
@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;

    @PostMapping("/login")
    public Result<UserRespDTO> login(@RequestBody UserReqDTO userReqDTO, HttpSession httpSession){
        log.info(userReqDTO.toString());
        Result<UserRespDTO> res = userService.login(userReqDTO,httpSession);
        return res;

    }

    @PostMapping("/register")
    public Result register(@RequestBody UserReqDTO userReqDTO){
        Result res = userService.register(userReqDTO);
        return res;
    }

    @GetMapping("/logout")
    public Result logout(HttpServletRequest request){
        request.getSession().removeAttribute("userName");
        return Result.SUCCESS();
    }

}
