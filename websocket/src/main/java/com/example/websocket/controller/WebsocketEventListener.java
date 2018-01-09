package com.example.websocket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.example.websocket.model.ChatMessage;

import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;

@Component
public class WebsocketEventListener
{
private static final Logger logger=LoggerFactory.getLogger(WebsocketEventListener.class);

@Autowired
private SimpMessageSendingOperations messagingTemplate;

@EventListener
public void handleWebSocketDisconnectListenerChat(SessionDisconnectEvent event) {
	StompHeaderAccessor headerAccessor=StompHeaderAccessor.wrap(event.getMessage());
	
	String username=(String) headerAccessor.getSessionAttributes().get("username");
	if(username != null)
	{
		logger.info("User get Disconnected:"+username);
		ChatMessage chatMessage=new ChatMessage();
		chatMessage.setType(ChatMessage.MessageType.LEAVE);
		chatMessage.setSender(username);
		
		messagingTemplate.convertAndSend("/topic/public",chatMessage);
	}
}
	
}
