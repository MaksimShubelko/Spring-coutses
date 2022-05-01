package com.example.springcourses.controller;

import com.example.springcourses.services.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class AnswerController {

    private final AnswerService answerService;
}
