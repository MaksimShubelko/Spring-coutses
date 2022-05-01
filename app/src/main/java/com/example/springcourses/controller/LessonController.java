package com.example.springcourses.controller;

import com.example.springcourses.services.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class LessonController {

    private final LessonService lessonService;
}
