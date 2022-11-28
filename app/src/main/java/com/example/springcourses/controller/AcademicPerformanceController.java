package com.example.springcourses.controller;

import com.example.springcourses.services.AcademicPerformanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@RequiredArgsConstructor
@Controller
public class AcademicPerformanceController {

    private final AcademicPerformanceService academicPerformanceService;

    @GetMapping("/academic-performances")
    public String getAcademicPerformances() {
        return "academic-performances/index";
    }
}
