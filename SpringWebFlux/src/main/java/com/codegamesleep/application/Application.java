package com.codegamesleep.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication(scanBasePackages = {
        "com.codegamesleep.application.config",
        "com.codegamesleep.application.routers",
        "com.codegamesleep.application.handlers"
})
@EnableWebFlux
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
