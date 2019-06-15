package com.hwcao.iot.service;

import com.hwcao.iot.dto.UserDTO;
import com.hwcao.iot.entity.user.User;

/**
 * @program: iots_pringboot
 * @description:
 * @author: dyingstraw
 * @create: 2019-06-12 20:11
 **/
public interface UserService {
    /**
     * 通过用户名查找用户
     * @param name
     * @return
     */
    public UserDTO getUserByName(String name);

    User getUserById(String name);
}
