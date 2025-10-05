package com.health.advisor.config;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@Slf4j
public class Configs {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Bean("memory")
    public ChatClient chatClient(ChatClient.Builder builder, ChatMemory chatMemory){
        log.info(chatMemory.getClass().getName());
        MessageChatMemoryAdvisor messageChatMemoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemory).build();
        return builder.defaultAdvisors(messageChatMemoryAdvisor).build();
    }
}
