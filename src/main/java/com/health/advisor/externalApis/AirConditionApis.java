package com.health.advisor.externalApis;

import com.health.advisor.RequestDto.AirQualityRequest;
import com.health.advisor.config.AirQualityMapper;
import com.health.advisor.entity.AirQualityEntity;
import com.health.advisor.repository.AirQualityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AirConditionApis {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private AirQualityRepository airQualityRepository;

    public AirQualityEntity getAirQuality(String city){
        String API_URL="https://api.waqi.info/feed/"+city+"/?token="+System.getenv("AQICN_API_KEY");

        AirQualityRequest template = restTemplate.getForObject(API_URL, AirQualityRequest.class);
        System.out.println(template);

        AirQualityEntity airQualityEntity = AirQualityMapper.toEntity(template);
        System.out.println(airQualityEntity);

        if(airQualityEntity!=null){

        AirQualityEntity airQualityEntity1 = airQualityRepository.save(airQualityEntity);
        return airQualityEntity1;

        }else
            throw new IllegalArgumentException("from aircondition.class error in ");

    }
}
