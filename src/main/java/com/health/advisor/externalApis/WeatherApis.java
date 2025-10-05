package com.health.advisor.externalApis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherApis {

    @Autowired
    private RestTemplate restTemplate;

}
