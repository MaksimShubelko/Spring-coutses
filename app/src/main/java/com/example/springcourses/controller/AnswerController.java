package com.example.springcourses.controller;

import com.example.springcourses.services.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class AnswerController {

    private final AnswerService answerService;

    @GetMapping("/answers")
    public String getAnswers() {
        return "answers/index";
    }
}
