package com.example.springcourses.controller;

import com.example.springcourses.dto.CourseDto;
import com.example.springcourses.dto.GroupDto;
import com.example.springcourses.dto.RequestDto;
import com.example.springcourses.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/courses/{courseId}/groups/{groupId}/requests")
@Controller
public class RequestController {

    private final RequestService requestService;
    private final GroupService groupService;
    private final CourseService courseService;
    private final StudentService studentService;

    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping("/find")
    public String findRequests(CourseDto courseDto, Model model) {
        List<RequestDto> selections = requestService.findNewByCourse(courseDto);
        model.addAttribute("selections", selections);
        return "requests/index";
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping("/{requestId}/approve")
    public String initApproving(@PathVariable(name = "requestId") Long requestId, CourseDto courseDto, GroupDto groupDto) {
        requestService.addStudentToGroup(groupDto, requestId);
        return "redirect:/courses/" + courseDto.getCourseId() + "/groups/" + groupDto.getGroupId() + "/requests/find";
    }

    @ModelAttribute("groupDto")
    public GroupDto findGroup(@PathVariable("groupId") Long groupId) {
        return groupService.findById(groupId);
    }

    @ModelAttribute("courseDto")
    public CourseDto findCourse(@PathVariable("courseId") Long courseId) {
        return courseService.findById(courseId);
    }


}
