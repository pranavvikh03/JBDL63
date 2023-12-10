package com.example.demo.configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class devProfileTest {

    @Value("${user.name}")
    private String name;
    @PostConstruct
    public void test(){
        System.out.println("dev profile loaded: "+name);
    }
}
