package com.hwcao.iot.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hwcao.iot.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @program: iots_pringboot
 * @description:
 * @author: dyingstraw
 * @create: 2019-06-15 13:45
 **/
public abstract  class BaseDao<M extends BaseMapper<E>,E extends BaseEntity>{
    @Autowired
    BaseMapper baseMapper;
    public E getOneById(Serializable id){
        return ((M)baseMapper).selectById(id);
    }

}
