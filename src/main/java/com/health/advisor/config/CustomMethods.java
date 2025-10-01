package com.health.advisor.config;


import com.health.advisor.entity.User;

public class CustomMethods {
    public static String getUserString(User user){
        return "you are a health advisor : this user is " +user.getUserName() +" and my age is  "+user.getAge()+" and my gender is "+user.getGender()+" and i have these healthcondition :"+user.getHealthCondition();
    }
}
