package com.todo.websocket.service;


import com.todo.websocket.model.ChatMessage;
import com.todo.websocket.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;

    public void saveMessage(ChatMessage message) {
        chatMessageRepository.save(message);
    }
}
