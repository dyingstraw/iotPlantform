package com.hwcao.iot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hwcao.iot.dao.device.DeviceDao;
import com.hwcao.iot.dto.redisCache.RedisCacheDTO;
import com.hwcao.iot.entity.Result;
import com.hwcao.iot.entity.device.Device;
import com.hwcao.iot.service.RedisCacheService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class RedisCacheServiceImpl implements RedisCacheService {
    @Autowired
    private DeviceDao deviceDao;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public Result sync(String id) {
        if(StringUtils.isEmpty(id)){
           List<Device> deviceList = deviceDao.getList(new QueryWrapper());
            for (int i = 0; i < deviceList.size(); i++) {
                RedisCacheDTO redisCacheDTO = new RedisCacheDTO();
                BeanUtils.copyProperties(deviceList.get(i),redisCacheDTO);
                redisTemplate.opsForHash().put("auth",redisCacheDTO.getId().toString(),redisCacheDTO.getSecretKey());
            }
        }else{
            String[] ids = id.split(",");
            for (int i = 0; i <ids.length ; i++) {
                Device device = deviceDao.getOneById(ids[i]);
                RedisCacheDTO redisCacheDTO = new RedisCacheDTO();
                BeanUtils.copyProperties(device,redisCacheDTO);
                redisTemplate.opsForHash().put("auth",redisCacheDTO.getId().toString(),redisCacheDTO.getSecretKey());
            }
        }
        return null;
    }
}
