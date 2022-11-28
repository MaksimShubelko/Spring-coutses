package com.example.springcourses.controller;

import com.example.springcourses.services.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class TestController {

    private final TestService testService;

    @GetMapping("/tests")
    public String getTests() {
        return "tests/index";
    }
}
