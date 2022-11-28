package com.example.springcourses.controller;

import com.example.springcourses.dto.TeacherDto;
import com.example.springcourses.dto.UserDto;
import com.example.springcourses.services.TeacherService;
import com.example.springcourses.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/users/{userId}/teachers")
@Controller
public class TeacherController {

    private final TeacherService teacherService;
    private final UserService userService;

    @GetMapping
    public String getTeachers() {
        return "teachers/index";
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("teacherDto", TeacherDto.builder().build());
        return "teachers/createOrUpdate";
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping("/edit")
    public String initUpdateForm(Model model, @PathVariable Long userId) {
        model.addAttribute("teacherDto", teacherService.findByUserId(userId));
        return "teachers/createOrUpdate";
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @PostMapping("/new")
    public String processCreate(TeacherDto teacherDto, BindingResult bindingResult,
                                UserDto userDto) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.hasErrors());
            return "teachers/createOrUpdate";
        } else {
            userDto.setTeacherDto(teacherDto);
            System.out.println(userDto.getTeacherDto().getSalaryPerHour() + " gfgf");
            userService.save(userDto);
            return "redirect:/users/" + userDto.getUserId();
        }
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @PostMapping("/edit")
    public String processUpdate(TeacherDto teacherDto, BindingResult bindingResult, UserDto userDto) {
        if (bindingResult.hasErrors()) {
            return "teachers/createOrUpdate";
        } else {
            userDto.setTeacherDto(teacherDto);
            userService.save(userDto);
            return "redirect:/users/" + userDto.getUserId();
        }
    }

    @ModelAttribute("userDto")
    public UserDto findUser(@PathVariable("userId") Long userId) {
        return userService.findById(userId);
    }
}
