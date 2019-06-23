package com.hwcao.iot.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @program: iots_pringboot
 * @description:
 * @author: dyingstraw
 * @create: 2019-06-17 22:44
 **/
@Slf4j
public class MessageListener1 extends MessageListenerAdapter {
    @Override
    public void onMessage(Message message, byte[] pattern) {
      logger.info("m2:"+message);
    }
}
