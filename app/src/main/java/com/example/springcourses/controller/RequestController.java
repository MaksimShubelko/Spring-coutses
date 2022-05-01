package com.example.springcourses.controller;

import com.example.springcourses.services.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class RequestController {

    private final RequestService requestService;
}
