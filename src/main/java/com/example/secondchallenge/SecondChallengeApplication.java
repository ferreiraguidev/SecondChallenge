package com.example.secondchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SecondChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondChallengeApplication.class, args);
    }

}
