package com.health.advisor.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor@ToString
public class AirQuality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int aqi;
    private int idx;
    private String dominantPollutant;

    @Embedded
    private CityEntity city;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private IAQIEntity iaqi;

    private LocalDateTime measurementTime;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ForecastItemEntity> forecasts = new ArrayList<>();
}






