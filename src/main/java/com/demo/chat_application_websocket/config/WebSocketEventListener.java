package com.demo.chat_application_websocket.config;

import com.demo.chat_application_websocket.model.ChatMessage;
import com.demo.chat_application_websocket.model.MessageType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@Slf4j
public class WebSocketEventListener {


    @Autowired
    private SimpMessageSendingOperations template;

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {

        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = accessor.getSessionAttributes().get("username").toString();

        if (username != null) {
            log.info("User disconnected: {}", username);
            var chatMessage = ChatMessage.builder()
                    .sender(username)
                    .type(MessageType.LEAVE)
                    .build();

            template.convertAndSend( "/topic/public", chatMessage);
        }
    }
}
