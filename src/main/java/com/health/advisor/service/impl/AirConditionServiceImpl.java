package com.health.advisor.service.impl;

import com.health.advisor.entity.User;
import com.health.advisor.exceptionHandler.ResourceNotFoundException;
import com.health.advisor.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AirConditionServiceImpl {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper mapper;

    public void getAirCondition(String city,String userName){
        User user = userRepository.findByUserName(userName).orElseThrow(() -> new ResourceNotFoundException("user not found "));


    }
}
