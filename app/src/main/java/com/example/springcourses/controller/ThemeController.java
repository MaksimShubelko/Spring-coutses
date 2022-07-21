package com.example.springcourses.controller;

import com.example.springcourses.services.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ThemeController {

    private final ThemeService themeService;
}
