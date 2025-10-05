package com.health.advisor.externalApis;

import com.health.advisor.RequestDto.WeatherApiRequest;
import com.health.advisor.config.WeatherMapper;
import com.health.advisor.entity.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherApis {

    @Autowired
    private RestTemplate restTemplate;

    public WeatherData getWeatherApi(double lat,double lon){
        String WEATHER_API_URL="https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid="+System.getenv("OPENWEATHER_WEATHER_API_KEY");

        WeatherApiRequest weatherApiRequest = restTemplate.getForObject(WEATHER_API_URL, WeatherApiRequest.class);
        System.out.println(weatherApiRequest);

        return WeatherMapper.toEntity(weatherApiRequest);
    }
}
