package com.health.advisor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "air_quality")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AirQualityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int aqi;                     // Overall air quality index
    private String dominantPollutant;    // Main risk factor (dominant pollutant)

    // Minimal city info
    private String cityName;
    private double latitude;
    private double longitude;

    // Key pollutants
    private Double co;
    private Double h;
    private Double no2;
    private Double o3;
    private Double p;
    private Double pm10;
    private Double pm25;
    private Double so2;
    private Double t;  // temperature if provided in IAQI
    private Double w;  // wind if provided in IAQI

    private LocalDateTime measurementTime; // Measurement time
}
