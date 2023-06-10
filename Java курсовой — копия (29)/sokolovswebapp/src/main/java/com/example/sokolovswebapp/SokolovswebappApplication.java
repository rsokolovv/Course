package com.example.sokolovswebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.sokolovswebapp.services", "com.example.sokolovswebapp.config"})
@ComponentScan("com.example.sokolovswebapp.repositories")
public class SokolovswebappApplication {

    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String plainPassword = "123";
        String encryptedPassword = passwordEncoder.encode(plainPassword);
        System.out.println("Encrypted Password: " + encryptedPassword);

        SpringApplication.run(SokolovswebappApplication.class, args);
    }

}
