package com.hwcao.iot.listener;

import lombok.extern.slf4j.Slf4j;
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
    private Session session;

    private static HashMap<Session,Set<String>> hsSession = new HashMap<>();


    public static synchronized HashMap<Session,Set<String>> getSessions() {
        return hsSession;
    }

    public static synchronized void addSessions(Session session,String mess) {
        Set<String> set = new HashSet<>();
        String[] strings = mess.split(",");
        for (int i = 0; i <strings.length ; i++) {
            set.add(strings[i]);
        }
        WebSocketServer.hsSession.put(session,set);
    }

    //连接成功
    @OnOpen
    public void onOpen(Session session, @PathParam("mess") String mess){
        this.session = session;
        addSessions(session,mess);
        log.info("连接建立成功");
        try {
            sendMessage(mess);
        } catch (IOException e) {
            e.printStackTrace();
            log.info("webSocket 连接异常");
        }
    }
    @OnClose
    public void onClose(){
        getSessions().remove(this.session);
    }

    public  void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }
}
