package com.health.advisor.config;


import com.health.advisor.entity.User;

public class CustomMethods {
    public static String getSystemToString(){
        return "you are a health advisor AI . give advice according to user health";
    }
    public static String getUserToString(User user){
        return String.format(
                "User details: { name: %s, age: %d, gender: %s, healthCondition: %s }. " +
                        "Give a short health advice (not too long, not too short). " +
                        "Format the advice with a clear heading followed by bullet points.",
                user.getUserName(),
                user.getAge(),
                user.getGender(),
                user.getHealthCondition()
        );
    }
    public static String getAqiCategory(int aqi) {
        if (aqi <= 50) return "Good";
        else if (aqi <= 100) return "Moderate";
        else if (aqi <= 150) return "Unhealthy for Sensitive Groups";
        else if (aqi <= 200) return "Unhealthy";
        else if (aqi <= 300) return "Very Unhealthy";
        else return "Hazardous";
    }

}
