package com.example.springcourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private CacheProperties cacheProperties;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(cacheProperties.getGroup());
    }
}
