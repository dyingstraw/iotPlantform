package com.hwcao.iot.dao.user;

import com.hwcao.iot.dto.UserDTO;
import org.springframework.stereotype.Component;

/**
 * @program: iots_pringboot
 * @description:
 * @author: dyingstraw
 * @create: 2019-06-12 20:13
 **/
@Component
public class UserDao {
    public UserDTO getUserByName(String name){
        UserDTO user = new UserDTO();
        user.setDesc("admin");
        user.setName(name);
        user.setId(1L);
        return user;

    }
    public UserDTO getUserById(Long id){
        UserDTO user = new UserDTO();
        user.setDesc("admin");
        user.setName("admin");
        user.setId(id);
        return user;
    }
    public boolean checkUser(String username,String password){
        return true;
    }
}
