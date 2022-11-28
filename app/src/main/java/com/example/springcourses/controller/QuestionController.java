package com.example.springcourses.controller;

import com.example.springcourses.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/questions")
    public String getQuestions() {
        return "questions/index";
    }
}
