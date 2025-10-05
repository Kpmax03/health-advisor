package com.health.advisor.config;



import com.health.advisor.RequestDto.AirQualityRequest;
import com.health.advisor.entity.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AirQualityMapper {
    public static AirQualityEntity toEntity(AirQualityRequest dto) {
        if (dto == null || dto.getData() == null) return null;

        AirQualityRequest.Data data = dto.getData();
        AirQualityRequest.IAQI iaqi = data.getIaqi();
        AirQualityRequest.City city = data.getCity();

        return AirQualityEntity.builder()
                .aqi(data.getAqi())
                .dominantPollutant(data.getDominentpol())
                .cityName(city.getName())
                .latitude(city.getGeo() != null && !city.getGeo().isEmpty() ? city.getGeo().get(0) : 0)
                .longitude(city.getGeo() != null && city.getGeo().size() > 1 ? city.getGeo().get(1) : 0)
                .co(iaqi != null && iaqi.getCo() != null ? iaqi.getCo().getV() : null)
                .h(iaqi != null && iaqi.getH() != null ? iaqi.getH().getV() : null)
                .no2(iaqi != null && iaqi.getNo2() != null ? iaqi.getNo2().getV() : null)
                .o3(iaqi != null && iaqi.getO3() != null ? iaqi.getO3().getV() : null)
                .p(iaqi != null && iaqi.getP() != null ? iaqi.getP().getV() : null)
                .pm10(iaqi != null && iaqi.getPm10() != null ? iaqi.getPm10().getV() : null)
                .pm25(iaqi != null && iaqi.getPm25() != null ? iaqi.getPm25().getV() : null)
                .so2(iaqi != null && iaqi.getSo2() != null ? iaqi.getSo2().getV() : null)
                .t(iaqi != null && iaqi.getT() != null ? iaqi.getT().getV() : null)
                .w(iaqi != null && iaqi.getW() != null ? iaqi.getW().getV() : null)
                .measurementTime(data.getTime() != null ?
                        LocalDateTime.ofEpochSecond(data.getTime().getV(), 0, java.time.ZoneOffset.UTC)
                        : null)
                .build();
    }
}

