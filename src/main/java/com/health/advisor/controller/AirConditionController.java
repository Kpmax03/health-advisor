package com.health.advisor.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.health.advisor.ResponseDto.HealthAdviceResponse;
import com.health.advisor.service.AirConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class AirConditionController {
    @Autowired
    private AirConditionService airConditionService;

    @GetMapping("/check")
    public HealthAdviceResponse getCondition(@RequestParam String city, @RequestParam String senderUserName) throws JsonProcessingException {
        return airConditionService.getAirCondition(city,senderUserName);
    }
}
