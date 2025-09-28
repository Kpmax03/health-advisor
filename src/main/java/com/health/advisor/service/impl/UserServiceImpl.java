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

import java.security.Principal;
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
    public String DeleteUser(String userName, Principal principal) {
        String owner = principal.getName();

        User loggedUser = userRepository.findByUserName(owner).orElseThrow(()->new ResourceNotFoundException("userid not found"));
        User deletingUser = userRepository.findByUserName(userName).orElseThrow(()->new ResourceNotFoundException("userid not found"));

        if(loggedUser==deletingUser){
            userRepository.delete(deletingUser);
            return "deleted user of userName ="+userName;
        }else{
            return "you don't own to that account";
        }
    }
}
