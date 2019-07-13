package com.hwcao.iot.entity.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hwcao.iot.entity.BaseEntity;
import lombok.Data;

/**
 * @program: iots_pringboot
 * @description:
 * @author: dyingstraw
 * @create: 2019-06-12 19:56
 **/
@Data
@TableName("t_user")
public class User extends BaseEntity {

    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户描述
     */
    private String userDesc;
    /**
     * 用户密码
     */
    private String password;

}
