package com.hwcao.iot.service.impl;

import com.hwcao.iot.mapper.UserMapper;
import com.hwcao.iot.dao.user.UserDao;
import com.hwcao.iot.entity.user.User;
import com.hwcao.iot.service.UserService;
import com.hwcao.iot.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDTO getUserByName(String name) {
        return null;
    }

    @Override
    public User getUserById(String name) {
        return userDao.getOneById(1);
    }
}
