package com.hwcao.iot.dao.user;

import com.hwcao.iot.dao.BaseDao;
import com.hwcao.iot.dao.mapper.UserMapper;
import com.hwcao.iot.entity.user.User;
import org.springframework.stereotype.Component;

/**
 * @program: iots_pringboot
 * @description:
 * @author: dyingstraw
 * @create: 2019-06-12 20:13
 **/
@Component
public class UserDao extends BaseDao<UserMapper, User> {
}
