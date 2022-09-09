package com.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.master")
public class EngineeringToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(EngineeringToolApplication.class, args);
    }

}
