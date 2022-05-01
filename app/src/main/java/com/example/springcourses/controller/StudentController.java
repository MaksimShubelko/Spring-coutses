package com.example.springcourses.controller;

import com.example.springcourses.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class StudentController {

    private final StudentService studentService;
}
