package com.websocket02.websocket02.controllers;

import com.websocket02.websocket02.dto.ClientMessageDTO;
import com.websocket02.websocket02.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    SimpMessagingTemplate smt;

    @PostMapping("/broadcast-message")
    public ResponseEntity sendNotificationToClients(@RequestBody MessageDTO message){
        smt.convertAndSend("/broadcast/client-message", message);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @SendTo("/broadcast")
    @MessageMapping("/hello")
    public ClientMessageDTO handleMessageFromWebSocket(ClientMessageDTO message){
        System.out.println("Arrived something on /app/hello" );
        return new ClientMessageDTO(message.getClientName(), message.getClientAlert(), message.getClientMSG());
    }
}
