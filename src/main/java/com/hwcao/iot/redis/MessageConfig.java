package com.hwcao.iot.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.Executors;

/**
 * @program: iots_pringboot
 * @description:
 * @author: dyingstraw
 * @create: 2019-06-17 22:46
 **/
@Configuration
public class MessageConfig {

    @Bean
    MessageListenerAdapter messageListener(){
        return new MessageListenerAdapter(new MessageListener1());
    }

    @Bean
    RedisMessageListenerContainer redisContainer(RedisConnectionFactory factory) {
        //容器
        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        //设置连接工厂
        container.setConnectionFactory(factory);
        //订阅topic
        container.addMessageListener(messageListener(), topic());
        container.addMessageListener(messageListener(), topic());
        //container.addMessageListener(messageListener(), topic2());
        //可订阅多个频道
        //创建线程池
        container.setTaskExecutor(Executors.newFixedThreadPool(4));
        return container;
    }

    @Bean
    ChannelTopic topic() {
        return new ChannelTopic("testRedis");
    }
}
