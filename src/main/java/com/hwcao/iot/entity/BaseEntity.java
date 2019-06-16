package com.hwcao.iot.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: iots_pringboot
 * @description:
 * @author: dyingstraw
 * @create: 2019-06-12 19:53
 **/
@Data
public class BaseEntity implements Serializable {

    @TableId
    protected Long id;
    protected Date createTime;
    protected Long createUser;
    protected Date updateTime;
    protected Long updateUser;
    protected Integer delFlag;
}
