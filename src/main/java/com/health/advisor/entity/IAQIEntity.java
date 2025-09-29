package com.health.advisor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor@ToString
public class IAQIEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private Double co;
   private Double h;
   private Double no2;
   private Double o3;
   private Double p;
   private Double pm10;
   private Double pm25;
   private Double so2;
   private Double t;
   private Double w;
}
