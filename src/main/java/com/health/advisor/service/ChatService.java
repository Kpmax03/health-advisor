package com.health.advisor.service;

import reactor.core.publisher.Flux;

public interface ChatService {
    public Flux<String> chat(String query);
}
