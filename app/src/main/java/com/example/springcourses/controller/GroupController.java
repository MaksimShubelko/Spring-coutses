package com.example.springcourses.controller;

import com.example.springcourses.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class GroupController {

    private final GroupService groupService;

    @GetMapping("/groups")
    public String getGroups() {
        return "groups/index";
    }
}
