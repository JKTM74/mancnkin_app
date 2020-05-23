package com.manchkin.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.manchkin.app"})
@EntityScan("com.manchkin.app.jpa.models")
@EnableJpaRepositories("com.manchkin.app.jpa.repositories")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
