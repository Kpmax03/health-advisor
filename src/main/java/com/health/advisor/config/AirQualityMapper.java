package com.health.advisor.config;



import com.health.advisor.RequestDto.AirQualityRequest;
import com.health.advisor.entity.AirQuality;
import com.health.advisor.entity.CityEntity;
import com.health.advisor.entity.ForecastItemEntity;
import com.health.advisor.entity.IAQIEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class AirQualityMapper {

    public static AirQuality toEntity(AirQualityRequest dto) {
        if (dto == null || dto.getData() == null) return null;

        AirQualityRequest.Data data = dto.getData();

        // Map city
        CityEntity city = null;
        if (data.getCity() != null) {
            List<Double> geo = data.getCity().getGeo();
            double lat = (geo != null && geo.size() > 0) ? geo.get(0) : 0.0;
            double lon = (geo != null && geo.size() > 1) ? geo.get(1) : 0.0;

            city = new CityEntity(
                    data.getCity().getName(),
                    data.getCity().getUrl(),
                    data.getCity().getLocation(),
                    lat,
                    lon
            );
        }

        // Map IAQI
        IAQIEntity iaqi = null;
        if (data.getIaqi() != null) {
            AirQualityRequest.IAQI i = data.getIaqi();
            iaqi = new IAQIEntity(null,
                    getVal(i.getCo()),
                    getVal(i.getH()),
                    getVal(i.getNo2()),
                    getVal(i.getO3()),
                    getVal(i.getP()),
                    getVal(i.getPm10()),
                    getVal(i.getPm25()),
                    getVal(i.getSo2()),
                    getVal(i.getT()),
                    getVal(i.getW())
            );
        }

        // Map forecasts
        List<ForecastItemEntity> forecasts = null;
        if (data.getForecast() != null && data.getForecast().getDaily() != null) {
            forecasts = mapForecasts(data.getForecast().getDaily());
        }

        // Parse time
        LocalDateTime measurementTime = null;
        if (data.getTime() != null && data.getTime().getIso() != null) {
            measurementTime = LocalDateTime.parse(
                    data.getTime().getIso(),
                    DateTimeFormatter.ISO_OFFSET_DATE_TIME
            );
        }

        // Build entity
        AirQuality entity = new AirQuality();
        entity.setAqi(data.getAqi());
        entity.setIdx(data.getIdx());
        entity.setDominantPollutant(data.getDominentpol());
        entity.setCity(city);
        entity.setIaqi(iaqi);
        entity.setMeasurementTime(measurementTime);
        entity.setForecasts(forecasts);

        return entity;
    }

    private static Double getVal(AirQualityRequest.Value v) {
        return v != null ? v.getV() : null;
    }

    private static List<ForecastItemEntity> mapForecasts(AirQualityRequest.Daily daily) {
        return List.of(
                mapForecastList("pm25", daily.getPm25()),
                mapForecastList("pm10", daily.getPm10()),
                mapForecastList("o3", daily.getO3()),
                mapForecastList("uvi", daily.getUvi())
        ).stream().flatMap(List::stream).collect(Collectors.toList());
    }

    private static List<ForecastItemEntity> mapForecastList(String type, List<AirQualityRequest.ForecastItem> items) {
        if (items == null) return List.of();
        return items.stream().map(f -> new ForecastItemEntity(
                null,
                type,
                LocalDate.parse(f.getDay()), // forecast day is yyyy-MM-dd
                f.getAvg(),
                f.getMax(),
                f.getMin()
        )).collect(Collectors.toList());
    }
}
