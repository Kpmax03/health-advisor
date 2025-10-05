package com.health.advisor.ai;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.health.advisor.config.CustomMethods;
import com.health.advisor.entity.*;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class OllamaService {

    private ChatClient chatClient;

    @Autowired()
    @Qualifier("memory")
    private ChatClient imMemoryChatClient;

    public OllamaService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String getAdvice(User user, AirQualityEntity airQuality, WeatherData weatherData) throws JsonProcessingException {
        String content =chatClient
                .prompt(airQuality.toString()+"."+weatherData.toString())
                .system(CustomMethods.getSystemToString())
                .user(CustomMethods.getUserToString(user))
                .call()
                .content();
        System.out.println(content);
        return content;
    }

    public Flux<String> getChatResponse(String query){
        return imMemoryChatClient
                .prompt(query)
                .stream()
                .content();
    }
}
