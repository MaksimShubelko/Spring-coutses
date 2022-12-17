package com.example.springcourses.controller;

import com.example.springcourses.dto.CourseDto;
import com.example.springcourses.dto.ThemeDto;
import com.example.springcourses.services.CourseService;
import com.example.springcourses.services.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/courses/{courseId}/themes")
@Controller
public class ThemeController {

    private final ThemeService themeService;
    private final CourseService courseService;

    @GetMapping("/themes")
    public String getThemes() {
        return "themes/index";
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping("/{themeId}/edit")
    public String initUpdating(@PathVariable(name = "themeId") Long themeId, Model model) {
        ThemeDto themeDto = themeService.findById(themeId);
        model.addAttribute("themeDto", themeDto);
        return "themes/edition";

    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @PostMapping("/{themeId}/edit")
    public String processUpdating(@PathVariable(name = "themeId") Long themeId, @Valid ThemeDto themeDto, BindingResult bindingResult, CourseDto courseDto) {
        if (bindingResult.hasErrors()) {
            return "themes/edition";
        } else {
            themeDto.setThemeId(themeId);
            themeDto.setCourseDto(courseDto);
            themeService.save(themeDto);
            return "redirect:/courses/" + courseDto.getCourseId() + "/edit";
        }

    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping("/create")
    public String initCreating(Model model) {
        ThemeDto themeDto = ThemeDto.builder().build();
        model.addAttribute("themeDto", themeDto);
        return "themes/creation";
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @PostMapping("/create")
    public String processCreating(CourseDto courseDto, @Valid ThemeDto themeDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "themes/creation";
        } else {
            themeDto.setCourseDto(courseDto);
            themeService.save(themeDto);
            return "redirect:/courses/" + courseDto.getCourseId() + "/edit";
        }
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping("/{themeId}/delete")
    public String deleteTheme(@PathVariable(name = "themeId") Long themeId, CourseDto courseDto) {
        themeService.delete(themeId);
        return "redirect:/courses/" + courseDto.getCourseId() + "/edit";
    }

    @ModelAttribute("courseDto")
    public CourseDto findCourse(@PathVariable("courseId") Long courseId) {
        return courseService.findById(courseId);
    }

}
