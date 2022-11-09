package com.todo.chat.controller;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.todo.chat.model.ChattingMessage;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
public class ChattingHistoryDAO {

    // A simple cache for temporarily storing chat data
    private final Map<String,Cache<UUID, ChattingMessage>> cacheList = new HashMap<>();

    private final Cache<UUID, ChattingMessage> chatHistoryCache = CacheBuilder
            .newBuilder().maximumSize(20).expireAfterWrite(10, TimeUnit.MINUTES)
            .build();

    public void save(ChattingMessage chatObj) {
//      this.chatHistoryCache.put(UUID.randomUUID(), chatObj);
        String roomId = chatObj.getRoomId();
        if(cacheList.containsKey(roomId)){
            cacheList.get(roomId).put(UUID.randomUUID(), chatObj);
        }else{
            Cache<UUID, ChattingMessage> chatHistoryCache = CacheBuilder
                    .newBuilder().maximumSize(20).expireAfterWrite(10, TimeUnit.MINUTES)
                    .build();
            chatHistoryCache.put(UUID.randomUUID(), chatObj);
            cacheList.put(roomId,chatHistoryCache);
            System.out.println(roomId);
            System.out.println(this.cacheList);
        }
    }

    public List<ChattingMessage> get(String roomId) {
//        return chatHistoryCache.asMap().values().stream()
//                .sorted(Comparator.comparing(ChattingMessage::getTimeStamp))
//                .collect(Collectors.toList());
//        System.out.println(cacheList);
        if(cacheList.containsKey(roomId)){
            return (List<ChattingMessage>) cacheList.get(roomId).asMap().values().stream()
                            .sorted(Comparator.comparing(ChattingMessage::getTimeStamp))
                            .collect(Collectors.toList());

        }else{
            return new ArrayList<>();
        }
    }
    }