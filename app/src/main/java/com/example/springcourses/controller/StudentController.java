package com.example.springcourses.controller;

import com.example.springcourses.dto.StudentDto;
import com.example.springcourses.dto.TeacherDto;
import com.example.springcourses.dto.UserDto;
import com.example.springcourses.services.StudentService;
import com.example.springcourses.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/students")
@Controller
public class StudentController {

    private final StudentService studentService;
    private final UserService userService;

    @GetMapping("/students")
    public String getStudents() {
        return "students/index";
    }

    @GetMapping("/new/{id}")
    public String initCreationForm(@PathVariable Long id, Model model) {
        model.addAttribute("teacher", TeacherDto.builder().build());
        return "createOrUpdate";
    }

    @PostMapping("/new/{id}")
    public String processCreation(StudentDto studentDto, BindingResult bindingResult,
                                @PathVariable(name = "id") Long userId) {
        if (bindingResult.hasErrors()) {
            return "students/create";
        } else {
            UserDto userDto = userService.findById(userId);
            userDto.setStudentDto(studentDto);
            userService.save(userDto);

            return "redirect:/users/" + userId;
        }
    }
}
