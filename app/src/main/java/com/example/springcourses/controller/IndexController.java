package com.example.springcourses.controller;

import com.example.springcourses.dto.UserDto;
import com.example.springcourses.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final UserService userService;

    @RequestMapping(value = {"", "/", "index", "index.html"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = {"test"})
    public String index(Model model) {
        Collection<UserDto> userDtos = userService.findAll();
        model.addAttribute("users", userDtos);
        model.addAttribute("test_attr", "test_val");
        return "index";
    }
}
