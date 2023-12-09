package com.example.nasatelegrambotspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class NasaTelegramBotSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(NasaTelegramBotSpringApplication.class, args);
    }

}
