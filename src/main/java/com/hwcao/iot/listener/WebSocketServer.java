package com.hwcao.iot.listener;

import com.hwcao.iot.service.RealControlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

@Slf4j
@ServerEndpoint("/ws/{mess}")
@Component
public class WebSocketServer {
    @Autowired
    private RealControlService realControlService;
    @Autowired
    private static RedisTemplate redisTemplate;

    private Session session;
    private static HashMap<Session,Set<String>> hsSession = new HashMap<>();

    /**
     * 存储客户端与服务器之间的会话，和客户端需要的设备ID
     * @return
     */
    public static synchronized HashMap<Session,Set<String>> getSessions() {
        return hsSession;
    }

    /**
     * 将请求的设备编号和对应的
     * @param session
     * @param mess
     */
    public static synchronized void addSessions(Session session,String mess) {
        Set<String> set = new HashSet<>();
        String[] strings = mess.split(",");
        for (int i = 0; i <strings.length ; i++) {
            set.add(strings[i]);
            //将需要实现显示的数据放入到缓存中
            redisTemplate.opsForHash().increment("devList",strings[i],1);
        }
        WebSocketServer.hsSession.put(session,set);
    }

    /**
     * 移除
     * @param session
     * @param mess
     */

    public static synchronized void removeSessions(Session session,String mess) {
        String[] strings = mess.split(",");
        for (int i = 0; i <strings.length ; i++) {
            //将需要关闭的设备从缓存中移除
            redisTemplate.opsForHash().increment("devList",strings[i],-1);
        }
        getSessions().remove(session);
    }

    /**
     * 连接成功后，将会话session存入到hashmap
     */

    @OnOpen
    public void onOpen(Session session, @PathParam("mess") String mess){
        this.session = session;
        addSessions(session,mess);
        //如果hsSession中存在连接，则打开订阅
        if(!hsSession.isEmpty()){
            realControlService.startSubscribe();
        }
        log.info("连接建立成功");
        try {
            sendMessage(mess);
        } catch (IOException e) {
            e.printStackTrace();
            log.info("webSocket 连接异常");
        }
    }

    /**
     * 连接关闭，将会话从hashmap中移除。判断hashmap中是否为空，如果为空则需要取消订阅服务。
     */
    @OnClose
    public void onClose(Session session, @PathParam("mess") String mess){
        //每次关闭需要从redis中移除
        removeSessions(session,mess);

        if(hsSession.isEmpty()){
            realControlService.cancelSubscribe();
        }
    }

    public  void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }
}
