package com.example.springcourses.controller;

import com.example.springcourses.services.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class RequestController {

    private final RequestService requestService;

    @GetMapping("/requests")
    public String getRequests() {
        return "requests/index";
    }
}
