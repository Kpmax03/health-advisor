package com.health.advisor.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.health.advisor.ResponseDto.HealthAdviceResponse;
import com.health.advisor.ai.OllamaService;
import com.health.advisor.config.CustomMethods;
import com.health.advisor.entity.*;
import com.health.advisor.exceptionHandler.ResourceNotFoundException;
import com.health.advisor.externalApis.AirConditionApis;
import com.health.advisor.externalApis.WeatherApis;
import com.health.advisor.repository.UserRepository;
import com.health.advisor.service.AirConditionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirConditionServiceImpl implements AirConditionService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private AirConditionApis airConditionApis;
    @Autowired
    private OllamaService ollamaService;
    @Autowired
    private WeatherApis weatherApis;

    public HealthAdviceResponse getAirCondition(String city,String userName) throws JsonProcessingException {
        User user = userRepository.findByUserName(userName).orElseThrow(() -> new ResourceNotFoundException("user not found "));

      //  AirQuality airQuality = airConditionApis.getAirQuality(city);
        AirQualityEntity airQualityEntity = airConditionApis.getAirQuality(city);
        WeatherData weatherData = weatherApis.getWeatherApi(airQualityEntity.getLatitude(), airQualityEntity.getLongitude());

        System.out.println(airQualityEntity.toString());

        String response = ollamaService.getAdvice(user, airQualityEntity,weatherData);

        return HealthAdviceResponse.builder()
                .healthCondition(user.getHealthCondition())
                .advice(response)
                .city(city)
                .aqi(airQualityEntity.getAqi())
                .riskLevel(CustomMethods.getAqiCategory(airQualityEntity.getAqi()))
                .airQuality(airQualityEntity)
                .build();
    }
}
