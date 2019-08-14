package com.hwcao.iot.listener;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.Future;

/**
 * @program: iots_pringboot
 * @description: redis订阅监听,这是一个自定义监听器处理器
 * @author: dyingstraw
 * @create: 2019-07-07 21:40
 **/
@Slf4j
@Component("redisReceiverService")
public class RedisReceiverService {
    /**
     * message及为订阅通道的message
     * @param message
     */
    public void receiveMessage(String message) {
        log.info("redis receive:{}",message);
        JSONObject inMsgData = (JSONObject) JSONObject.parse(message);
        //解析传入的数据为哪个设备的
        String devId = String.valueOf(inMsgData.get("devId"));
        log.info("【devId】"+devId);

        //依次遍历，找到session，发送
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
