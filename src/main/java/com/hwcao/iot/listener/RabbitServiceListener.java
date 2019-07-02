package com.hwcao.iot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j

public class RabbitServiceListener {

    /**
     * 消息消费
     * @RabbitHandler 代表此方法为接受到消息后的处理方法
     */
    @RabbitListener(queues = "hello",containerFactory="rabbitListenerContainerFactory")
    @RabbitHandler
    public void recieved(byte[] msg) throws Exception {
       log.info("[hello] recieved message:" + new String(msg));

    }
}
