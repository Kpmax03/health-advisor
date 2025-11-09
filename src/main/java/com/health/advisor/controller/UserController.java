package com.health.advisor.controller;

import com.health.advisor.RequestDto.UserRequest;
import com.health.advisor.ResponseDto.UserResponse;
import com.health.advisor.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
@Controller
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3001") // allow React requests
@Slf4j
public class UserController {

        @Autowired
        private UserService userService;

        @GetMapping("/")
        public String index(){
            return "admin/index";
        }

        @PostMapping("/SignUp")
        public ResponseEntity<UserResponse> signup(@RequestBody UserRequest request){
            log.info("{}",request);
            return ResponseEntity.ok(userService.createUser(request));
        }
        @DeleteMapping("/delete")
        public ResponseEntity<String> deleteUser(@RequestParam String userName,@RequestParam String password){
            return ResponseEntity.ok(userService.DeleteUser(userName,password));
        }
        @PostMapping("/login")
        public ResponseEntity<String> login(@RequestParam String userName,@RequestParam String password){
            log.info("{},{}",userName,password);
            return ResponseEntity.ok(userService.login(userName,password));
        }
}
