package com.example.springcourses.controller;

import com.example.springcourses.services.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class LessonController {

    private final LessonService lessonService;

    @GetMapping("/lessons")
    public String getLessons() {
        return "lessons/index";
    }
}
