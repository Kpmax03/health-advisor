package com.health.advisor.service.impl;

import com.health.advisor.ai.OllamaService;
import com.health.advisor.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    OllamaService ollamaService;
    @Override
    public Flux<String> chat(String query) {
       return ollamaService.getChatResponse(query);
    }
}
