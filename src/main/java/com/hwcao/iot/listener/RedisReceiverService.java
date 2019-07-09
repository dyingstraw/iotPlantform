package com.hwcao.iot.listener;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

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
        JSONObject inMsg = (JSONObject) JSONObject.parse(message);
        JSONObject inMsgData = (JSONObject) inMsg.get("data");

        String devId = String.valueOf(inMsgData.get("devId"));
        log.info("【devId】"+devId);

        HashMap<Session, Set<String>> hsSession = WebSocketServer.getSessions();
        for(Session session:hsSession.keySet()){
            Set<String> mess = hsSession.get(session);
            if(mess.contains(devId)){
                try {
                    session.getBasicRemote().sendText(inMsgData.toJSONString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
