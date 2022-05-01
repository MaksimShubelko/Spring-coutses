package com.example.springcourses.controller;

import com.example.springcourses.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class GroupController {

    private final GroupService groupService;
}
