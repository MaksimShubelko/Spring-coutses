package com.example.springcourses.controller;

import com.example.springcourses.dto.CourseDto;
import com.example.springcourses.dto.ThemeDto;
import com.example.springcourses.services.CourseService;
import com.example.springcourses.services.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Collection;
import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/courses")
@Controller
public class CourseController {

    private final CourseService courseService;
    private final RequestService requestService;

    @GetMapping("/find")
    public String getCourses(Model model) {
        List<CourseDto> courseDtoList = courseService.findAll();
        model.addAttribute("selections", courseDtoList);
        return "courses/index";
    }

    @PreAuthorize("hasAuthority('STUDENT')")
    @GetMapping("/{courseId}/join")
    public String joinCourse(@PathVariable(name = "courseId") Long courseId, Principal principal) {
        requestService.addRequest(courseId, principal);
        return "redirect:/courses/find";
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping("/{courseId}/edit")
    public String initUpdating(@PathVariable(name = "courseId") Long courseId, Model model) {
        CourseDto courseDto = courseService.findById(courseId);
        model.addAttribute("courseDto", courseDto);
        return "courses/edition";
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @PostMapping("/{courseId}/edit")
    public String processUpdating(@Valid CourseDto courseDto, BindingResult bindingResult, @PathVariable(name = "courseId") Long courseId) {
        if (bindingResult.hasErrors()) {
            bindingResult.rejectValue("courseName", "Bad credentials");
            return "courses/edition";
        } else {
            courseDto.setCourseId(courseId);
            courseService.save(courseDto);
            return "redirect:/courses/find";
        }
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping("/create")
    public String initCreating(Model model) {
        model.addAttribute("courseDto", CourseDto.builder().build());
        return "courses/creation";
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @PostMapping("/create")
    public String processCreating(CourseDto courseDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "themes/creation";
        } else {
            courseService.save(courseDto);
            return "redirect:/courses/find";
        }
    }
}
