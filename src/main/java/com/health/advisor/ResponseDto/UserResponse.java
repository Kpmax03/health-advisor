package com.health.advisor.ResponseDto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserResponse {

    private String id;
    private String userName;
    private String password;
}
