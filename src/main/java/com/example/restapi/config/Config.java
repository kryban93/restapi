package com.example.restapi.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//@EnableSwagger2
public class Config {

    @Autowired
    private ObjectMapper objectMapper;
}
