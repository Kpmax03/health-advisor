package com.health.advisor.ResponseDto;

import com.health.advisor.entity.HealthCondition;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserResponse {

    private String id;
    private String userName;
    private int age;
    private String gender;
    private HealthCondition healthCondition;

}
