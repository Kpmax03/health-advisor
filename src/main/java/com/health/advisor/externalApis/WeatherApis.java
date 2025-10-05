package com.health.advisor.externalApis;

import com.health.advisor.RequestDto.WeatherApiRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherApis {

    @Autowired
    private RestTemplate restTemplate;

    @Scheduled(fixedRate = 6000)
    public WeatherApis getWeatherApi(){
        String WEATHER_API_URL="https://api.openweathermap.org/data/2.5/weather?lat=+lat+&lon=+lon+&appid="+System.getenv("OPENWEATHER_WEATHER_API_KEY");
        String AWEATHER_API_URL="https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid="+System.getenv("OPENWEATHER_WEATHER_API_KEY");
        WeatherApiRequest weatherApiRequest = restTemplate.getForObject(AWEATHER_API_URL, WeatherApiRequest.class);
        System.out.println(weatherApiRequest);
        return null;
    }
}
