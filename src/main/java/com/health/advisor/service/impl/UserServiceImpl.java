package com.health.advisor.service.impl;

import com.health.advisor.RequestDto.UserRequest;
import com.health.advisor.ResponseDto.UserResponse;
import com.health.advisor.entity.User;
import com.health.advisor.exceptionHandler.ResourceNotFoundException;
import com.health.advisor.repository.UserRepository;
import com.health.advisor.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public UserResponse createUser(UserRequest userRequest){

        User user = mapper.map(userRequest, User.class);
        user.setId(UUID.randomUUID().toString());
        User save = userRepository.save(user);

        return mapper.map(save,UserResponse.class);

    }
    @Override
    public String DeleteUser(String userName,String password) {

        User deletingUser = userRepository.findByUserName(userName).orElseThrow(()->new ResourceNotFoundException("userid not found"));

        if(deletingUser.getPassword().equals(password)){
            userRepository.delete(deletingUser);
            return "deleted user of user account ="+userName;
        }else{
            return "you don't own to that account";
        }
    }

    @Override
    public String login(String userName, String password) {
        User user = userRepository.findByUserName(userName).orElseThrow(() -> new ResourceNotFoundException("username not found"));
        if(user.getPassword().equals(password)){
            return "ok";
        }else{
            throw new IllegalArgumentException("password incorrect");
        }
    }
}
