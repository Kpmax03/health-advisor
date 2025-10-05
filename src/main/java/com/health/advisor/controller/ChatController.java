package com.health.advisor.controller;

import com.health.advisor.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @GetMapping("/ask")
    public ResponseEntity<Flux<String>> chat(@RequestParam("q") String query){
        return ResponseEntity.ok(chatService.chat(query));
    }
}
