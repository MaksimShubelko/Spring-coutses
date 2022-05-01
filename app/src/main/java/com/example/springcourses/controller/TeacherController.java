package com.example.springcourses.controller;

import com.example.springcourses.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class TeacherController {

    private final TeacherService teacherService;
}
