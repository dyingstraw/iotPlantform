package com.hwcao.iot.dao;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwcao.iot.config.CommonEnum;

import com.hwcao.iot.entity.BaseEntity;
import com.hwcao.iot.exception.CustomException;
import com.hwcao.iot.util.CommonUtil;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @program: iots_pringboot
 * @description:
 * @author: dyingstraw
 * @create: 2019-06-15 13:45
 **/
public class BaseDao <M extends BaseMapper<E>,E extends BaseEntity>extends ServiceImpl {


    /**
     * 通过id获取实体
     * @param id
     * @return
     */
    public E getOneById(Serializable id){
        QueryWrapper<E> wrapper = new QueryWrapper<>();
        wrapper.eq("del_flag",0).eq("id",id);

        return (E)super.getOne(wrapper);
    }

    /**
     * 根据条件查找表
     * @param wrapper
     * @return
     */
    public List<E> getList(QueryWrapper wrapper){
        wrapper.eq("del_flag",0);
        return (List<E>)super.list(wrapper);
    }

    /**
     * 根据id更新
     * @param entity
     * @return
     * @throws CustomException
     */
    public boolean update(E entity) throws CustomException {
        if (entity.getId()==null){
            throw new CustomException(String.format("{}.{}(主键)=null，无法进行下一步操作",entity.getClass(),"id"));
        }
        setTimeAndOptUser(entity,CommonEnum.UPDATE);
        return super.updateById(entity);
    }

    /**
     * 插入记录
     * @param entity
     * @return
     */
     public boolean add(E entity){
         setTimeAndOptUser(entity,CommonEnum.INSERT);
         return super.save(entity);
     }


    /**
     * 逻辑删除
     * @param id
     * @return
     */
    public boolean deleteById(Serializable id){
        E e = getOneById(id);
        e.setDelFlag(1);
        setTimeAndOptUser(e,CommonEnum.UPDATE);
        return super.updateById(e);
    }
    public boolean deleteById(E entity) throws CustomException {
        if (entity.getId()==null){
            throw new CustomException(String.format("{}.{}(主键)=null，无法进行下一步操作",entity.getClass(),"id"));
        }
        setTimeAndOptUser(entity,CommonEnum.UPDATE);
        entity.setDelFlag(1);
        return update(entity);
    }

    /**
     * 设置删除记录信息
     * @param entity
     * @param type
     */
    private void setTimeAndOptUser(E entity, CommonEnum type){
        if (type == CommonEnum.UPDATE){

        }else {
            entity.setCreateTime(new Date());
            entity.setCreateUser(CommonUtil.getHeaderUserId());
        }
    }

}
