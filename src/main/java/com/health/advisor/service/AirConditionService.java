package com.health.advisor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.health.advisor.ResponseDto.HealthAdviceResponse;

public interface AirConditionService {
    public HealthAdviceResponse getAirCondition(String city, String userName) throws JsonProcessingException;
}
