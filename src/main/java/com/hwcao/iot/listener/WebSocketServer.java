package com.hwcao.iot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Vector;

@Slf4j
@ServerEndpoint("/websocket/{mess}")
@Component
public class WebSocketServer {
    private Session session;
    private static Vector<Session> sessions = new Vector<>();


    public static synchronized Vector<Session> getSessions() {
        return sessions;
    }

    public static synchronized void addSessions(Session sessions) {
        WebSocketServer.sessions.add(sessions);
    }

    //连接成功
    @OnOpen
    public void onOpen(Session session, @PathParam("mess") String mess){
        this.session = session;
        addSessions(session);
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
