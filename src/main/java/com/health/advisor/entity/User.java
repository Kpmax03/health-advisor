package com.health.advisor.entity;

import com.health.advisor.enums.HealthCondition;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @Id
    private String id;
    @Column(unique = true)
    private String userName;
    private String password;
    private int age;
    private String gender;
    @Enumerated(EnumType.STRING)
    private HealthCondition healthCondition;

}
