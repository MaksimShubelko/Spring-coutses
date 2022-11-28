package com.example.springcourses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.example.springcourses.repository"})
@ComponentScan({"com.example.listener", "com.example.springcourses"})
@SpringBootApplication
public class SpringCoursesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCoursesApplication.class, args);
    }

}
