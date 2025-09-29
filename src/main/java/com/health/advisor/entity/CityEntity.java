package com.health.advisor.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor@ToString
 public class CityEntity {
    private String name;
    private String url;
    private String location;
    private double latitude;
    private double longitude;
}
