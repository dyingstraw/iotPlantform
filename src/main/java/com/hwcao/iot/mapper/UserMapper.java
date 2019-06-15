package com.hwcao.iot.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
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
@Component
public interface UserMapper extends BaseMapper<User> {
}
