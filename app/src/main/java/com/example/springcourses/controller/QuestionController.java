package com.example.springcourses.controller;

import com.example.springcourses.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;
}
