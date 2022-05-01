package com.example.springcourses.controller;

import com.example.springcourses.services.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class TestController {

    private final TestService testService;
}
