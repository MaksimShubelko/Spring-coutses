package com.example.springcourses.controller;

import com.example.springcourses.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class CourseController {

    private final CourseService courseService;
}
