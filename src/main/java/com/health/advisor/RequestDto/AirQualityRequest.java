package com.health.advisor.RequestDto;

import lombok.*;

import java.util.List;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor@ToString
public class AirQualityRequest {

        private String status;
        private Data data;

        // getters and setters
        @Getter@Setter@AllArgsConstructor@NoArgsConstructor@ToString
        public static class Data {
            private int aqi;
            private int idx;
            private List<Attribution> attributions;
            private City city;
            private String dominentpol;
            private IAQI iaqi;
            private Time time;
            private Forecast forecast;
            private Debug debug;
            // getters and setters
        }
        @Getter@Setter@AllArgsConstructor@NoArgsConstructor@ToString
        public static class Attribution {
            private String url;
            private String name;
            // getters and setters
        }
        @Getter@Setter@AllArgsConstructor@NoArgsConstructor@ToString
        public static class City {
            private List<Double> geo;
            private String name;
            private String url;
            private String location;
            // getters and setters
        }
        @Getter@Setter@AllArgsConstructor@NoArgsConstructor@ToString
        public static class IAQI {
            private Value co;
            private Value h;
            private Value no2;
            private Value o3;
            private Value p;
            private Value pm10;
            private Value pm25;
            private Value so2;
            private Value t;
            private Value w;
            // getters and setters
        }
        @Getter@Setter@AllArgsConstructor@NoArgsConstructor@ToString
        public static class Value {
            private double v;
            // getters and setters
        }
        @Getter@Setter@AllArgsConstructor@NoArgsConstructor@ToString
        public static class Time {
            private String s;
            private String tz;
            private long v;
            private String iso;
            // getters and setters
        }
        @Getter@Setter@AllArgsConstructor@NoArgsConstructor@ToString
        public static class Forecast {
            private Daily daily;
            // getters and setters
        }
        @Getter@Setter@AllArgsConstructor@NoArgsConstructor@ToString
        public static class Daily {
            private List<ForecastItem> o3;
            private List<ForecastItem> pm10;
            private List<ForecastItem> pm25;
            private List<ForecastItem> uvi;
            // getters and setters
        }
        @Getter@Setter@AllArgsConstructor@NoArgsConstructor@ToString
        public static class ForecastItem {
            private double avg;
            private String day;
            private double max;
            private double min;
            // getters and setters
        }
        @Getter@Setter@AllArgsConstructor@NoArgsConstructor@ToString
        public static class Debug {
            private String sync;
            // getters and setters
        }
    }

