package com.health.advisor.controller;

import com.health.advisor.RequestDto.UserRequest;
import com.health.advisor.ResponseDto.UserResponse;
import com.health.advisor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController {

        @Autowired
        private UserService userService;

        @PostMapping("/signup")
        public ResponseEntity<UserResponse> signup(@RequestBody UserRequest request){
            return ResponseEntity.ok(userService.createUser(request));
        }
        @DeleteMapping("/delete")
        public ResponseEntity<String> deleteUser(@RequestParam String userName,@RequestParam String password){
            return ResponseEntity.ok(userService.DeleteUser(userName,password));
        }

}
