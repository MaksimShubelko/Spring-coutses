package com.example.springcourses.controller;

import com.example.springcourses.services.AcademicPerformanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;


@RequiredArgsConstructor
@Controller
public class AcademicPerformanceController {

    private final AcademicPerformanceService academicPerformanceService;
}
