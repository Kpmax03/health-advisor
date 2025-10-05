package com.health.advisor.service;

import com.health.advisor.RequestDto.UserRequest;
import com.health.advisor.ResponseDto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

public interface UserService {
    public UserResponse createUser(UserRequest userRequest);
    public String DeleteUser(String userName,String password );
    public String login( String userName,  String password);
}
