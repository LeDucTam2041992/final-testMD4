package com.example.demo;

import com.example.demo.service.CityService;
import com.example.demo.service.CityServiceImpl;
import com.example.demo.service.NationService;
import com.example.demo.service.NationServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;

@SpringBootApplication
public class DemoApplication {
    @Bean
    public NationService nationService(){
        return new NationServiceImpl();
    }

    @Bean
    public CityService cityService(){
        return new CityServiceImpl();
    }



    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
