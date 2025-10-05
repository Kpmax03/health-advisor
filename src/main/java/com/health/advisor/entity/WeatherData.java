package com.health.advisor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "weather_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String mainWeather;
    private String description;

    private double temperature;
    private double feelsLike;
    private double humidity;
    private double windSpeed;
    private int pressure;

    private double visibility;
    private double rainVolume1h;
    private double cloudiness;
    private String country;
}
