package com.example.springcourses.controller;

import com.example.springcourses.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
}
