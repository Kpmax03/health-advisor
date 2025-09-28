package com.health.advisor.service;

import java.security.Principal;

public interface UserService {
    public UserResponse createUser(UserRequest userRequest);
    public String DeleteUser(String userName , Principal principal);
}
