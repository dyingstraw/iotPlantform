package com.hwcao.iot.service.impl;

import com.hwcao.iot.entity.Result;
import com.hwcao.iot.service.RealControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Service;

/**
 * @program: iots_pringboot
 * @description:
 * @author: dyingstraw
 * @create: 2019-07-07 21:54
 **/
@Service
public class RealControlServiceImpl implements RealControlService {
    @Autowired
    @Qualifier("myRedisMessageListenerContainer")
    RedisMessageListenerContainer redisMessageListenerContainer;

    @Autowired
    @Qualifier("myMessageListener")
    MessageListenerAdapter messageListenerAdapter;

    @Override
    public Result<Boolean> cancelSubscribe() {
        redisMessageListenerContainer.removeMessageListener(messageListenerAdapter);
        return Result.SUCCESS();
    }

    @Override
    public Result<Boolean> startSubscribe() {
        redisMessageListenerContainer.addMessageListener(messageListenerAdapter,new PatternTopic("realMessage"));
        return Result.SUCCESS();
    }
}
