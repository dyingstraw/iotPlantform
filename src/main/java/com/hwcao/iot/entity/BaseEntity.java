package com.hwcao.iot.entity;

import lombok.Data;

import java.util.Date;

/**
 * @program: iots_pringboot
 * @description:
 * @author: dyingstraw
 * @create: 2019-06-12 19:53
 **/
@Data
public class BaseEntity {


    protected Long id;
    protected Date create_time;
    protected Date create_user;
}
