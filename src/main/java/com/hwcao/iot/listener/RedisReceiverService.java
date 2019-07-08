package com.hwcao.iot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Vector;

/**
 * @program: iots_pringboot
 * @description: redis订阅监听
 * @author: dyingstraw
 * @create: 2019-07-07 21:40
 **/
@Slf4j
@Component("redisReceiverService")
public class RedisReceiverService {
    public void receiveMessage(String message) {
        log.info("redis receive:{}",message);
       Vector<Session> sessions = WebSocketServer.getSessions();
        sessions.stream().forEach(e->{
            try {
                e.getBasicRemote().sendText(message);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }
}
