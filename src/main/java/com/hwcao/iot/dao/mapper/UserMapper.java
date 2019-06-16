package com.hwcao.iot.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwcao.iot.entity.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @program: iots_pringboot
 * @description:
 * @author: dyingstraw
 * @create: 2019-06-15 13:44
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
