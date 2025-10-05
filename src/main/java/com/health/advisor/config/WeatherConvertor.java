package com.health.advisor.config;

import com.health.advisor.RequestDto.WeatherApiRequest;
import com.health.advisor.entity.WeatherData;

public class WeatherConvertor {

    public static WeatherData toEntity(WeatherApiRequest dto) {
        if (dto == null) {
            throw new IllegalArgumentException("WeatherApiRequest cannot be null");
        }

        return WeatherData.builder()
                .city(dto.getName())
                .country(dto.getSys() != null ? dto.getSys().getCountry() : null)
                .mainWeather(dto.getWeather() != null && !dto.getWeather().isEmpty()
                        ? dto.getWeather().get(0).getMain()
                        : null)
                .description(dto.getWeather() != null && !dto.getWeather().isEmpty()
                        ? dto.getWeather().get(0).getDescription()
                        : null)
                .temperature(dto.getMain() != null ? dto.getMain().getTemp() : 0.0)
                .feelsLike(dto.getMain() != null ? dto.getMain().getFeels_like() : 0.0)
                .humidity(dto.getMain() != null ? dto.getMain().getHumidity() : 0.0)
                .pressure(dto.getMain() != null ? dto.getMain().getPressure() : 0)
                .windSpeed(dto.getWind() != null ? dto.getWind().getSpeed() : 0.0)
                .visibility(dto.getVisibility())
                .rainVolume1h(dto.getRain() != null ? dto.getRain().getOneHour() : 0.0)
                .cloudiness(dto.getClouds() != null ? dto.getClouds().getAll() : 0.0)
                .build();
    }
}

