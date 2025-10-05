package com.health.advisor.ai;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.health.advisor.config.CustomMethods;
import com.health.advisor.entity.AirQuality;
import com.health.advisor.entity.User;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

@Component
public class OllamaService {

    private ChatClient chatClient;

    public OllamaService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String getResponse(User user, AirQuality airQuality) throws JsonProcessingException {
        String content =chatClient
                .prompt(airQuality.toString())
                .system(CustomMethods.getSystemToString())
                .user(CustomMethods.getUserToString(user))
                .call()
                .content();
        System.out.println(content);
        return content;
    }
}
