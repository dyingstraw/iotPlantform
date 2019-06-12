package com.hwcao.iot.entity.user;

import com.hwcao.iot.entity.BaseEntity;
import lombok.Data;

/**
 * @program: iots_pringboot
 * @description:
 * @author: dyingstraw
 * @create: 2019-06-12 19:56
 **/
@Data
public class User extends BaseEntity {

    /**
     * 用户名
     */
    private String name;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 描述
     */
    private String desc;
}
