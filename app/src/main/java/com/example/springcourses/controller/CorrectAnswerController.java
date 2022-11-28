package com.example.springcourses.controller;

import com.example.springcourses.services.CorrectAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class CorrectAnswerController {

    private final CorrectAnswerService correctAnswerService;

    @GetMapping("/correct-answers")
    public String getCorrectAnswers() {
        return "correct-answers/index";
    }
}
