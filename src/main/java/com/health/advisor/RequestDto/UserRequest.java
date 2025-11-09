package com.health.advisor.RequestDto;

import com.health.advisor.enums.HealthCondition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class  UserRequest {

    @NotNull(message = "username cant be null")
    private String userName;
    @NotNull(message = "password cant be null")
    private String password;
    @Size(max = 100,message = "please enter valid password")
    private int age;
    private String gender;
    private HealthCondition healthCondition;
}
