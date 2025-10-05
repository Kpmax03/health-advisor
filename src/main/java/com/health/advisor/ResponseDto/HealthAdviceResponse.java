package com.health.advisor.ResponseDto;

import com.health.advisor.entity.AirQualityEntity;
import com.health.advisor.enums.HealthCondition;
import lombok.*;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor@ToString@Builder
public class HealthAdviceResponse {
        private String city;
        private double aqi;
        private HealthCondition healthCondition;
        private String riskLevel; // INTERMEDIATE, VERY_RISKY
        private String advice;
        private AirQualityEntity airQuality;
    }

