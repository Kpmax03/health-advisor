package com.health.advisor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AirConditionController {

    @GetMapping("/check")
    public void getCondition(@RequestBody String city,@RequestBody String senderUserName){

    }
}
