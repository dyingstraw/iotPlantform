package com.hwcao.iot.service.impl;

import com.hwcao.iot.service.RedisPublish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

/**
 * @program: iots_pringboot
 * @description:
 * @author: dyingstraw
 * @create: 2019-06-17 22:41
 **/
@Service
public class RedisPublishImpl implements RedisPublish {


    @Autowired
    RedisTemplate redisTemplate;
    @Override
    public void publish(){
        ChannelTopic topic = new ChannelTopic("testRedis");
        redisTemplate.convertAndSend(topic.getTopic(),"Hi，I'm redis!");
    }
}
