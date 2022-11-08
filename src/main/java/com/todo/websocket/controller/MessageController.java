package com.todo.websocket.controller;


import com.todo.websocket.model.ChatMessage;
import com.todo.websocket.service.ChatMessageService;
import com.todo.websocket.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducerService producerService;

    private final ChatMessageService chatMessageService;

    @MessageMapping("/chat/message")
    public void enter(ChatMessage message) {
        producerService.sendMessage(message);
        chatMessageService.saveMessage(message);

    }
}
