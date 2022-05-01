package com.example.springcourses.controller;

import com.example.springcourses.services.CorrectAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class CorrectAnswerController {

    private final CorrectAnswerService correctAnswerService;
}
