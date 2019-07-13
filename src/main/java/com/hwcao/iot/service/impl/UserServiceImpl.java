package com.hwcao.iot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hwcao.iot.Enum.ResultEnum;
import com.hwcao.iot.dao.mapper.UserMapper;
import com.hwcao.iot.dao.user.UserDao;
import com.hwcao.iot.dto.User.UserReqDTO;
import com.hwcao.iot.dto.User.UserRespDTO;
import com.hwcao.iot.entity.Result;
import com.hwcao.iot.entity.user.User;
import com.hwcao.iot.service.UserService;
import com.hwcao.iot.dto.UserDTO;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: iots_pringboot
 * @description:
 * @author: dyingstraw
 * @create: 2019-06-12 20:11
 **/
@Service
public class UserServiceImpl implements UserService {
     @Autowired
    private UserDao userDao;

    @Override
    public Result<UserRespDTO> login(UserReqDTO userReqDTO, HttpSession httpSession) {
        User user = null;
        /**
         * 按照userName查询用户信息
         */
        UserRespDTO userRespDTO = new UserRespDTO();
        userRespDTO.setUserName(userReqDTO.getUserName());
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name",userReqDTO.getUserName());
        user = (User) userDao.getOne(queryWrapper);


        /**
         * 如果认证失败，则返回错误结果
         * 如果认证成功，则将session（userName）写入客户端
         */
        if(user == null){
            httpSession.invalidate();
            return Result.FAILED(ResultEnum.USER_LOGIN_ERROR.getCode(),
                    ResultEnum.USER_LOGIN_ERROR.getMessage());
        }

        if(user.getPassword().equals(userReqDTO.getPassword()) ){
            userRespDTO.setValid(true);
            httpSession.setAttribute("userName",userRespDTO.getUserName());
            httpSession.setMaxInactiveInterval(5*60);
        }else{
            return Result.FAILED(ResultEnum.USER_LOGIN_ERROR.getCode(),
                    ResultEnum.USER_LOGIN_ERROR.getMessage());
        }
        return Result.SUCCESS(userRespDTO);
    }

    @Override
    public Result register(UserReqDTO userReqDTO) {
        User user = new User();
        if(userReqDTO.getUserName()== null || userReqDTO.getPassword() == null || userReqDTO.getUserDesc() == null ){
            return Result.FAILED(ResultEnum.USER_REGISTER_ERROR.getCode(),ResultEnum.USER_LOGIN_ERROR.getMessage());
        }
        BeanUtils.copyProperties(userReqDTO,user);
        userDao.save(user);
        return Result.SUCCESS();
    }
}
