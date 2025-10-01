package com.health.advisor.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LlmFormator {
    private static final ObjectMapper mapper=new ObjectMapper();
    public static String getString(Object object) throws JsonProcessingException {
        try {

        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        }catch (JsonProcessingException e){
            System.out.println(e.getMessage());
            System.out.println("error while converting obj to string");
           return "error while converting obj to string";
        }
    }
}
