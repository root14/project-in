package com.root14.projectin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProjectInApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectInApplication.class, args);
    }

}
