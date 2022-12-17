package com.example.springcourses.controller;

import com.example.springcourses.dto.CourseDto;
import com.example.springcourses.dto.GroupDto;
import com.example.springcourses.dto.UserDto;
import com.example.springcourses.services.CourseService;
import com.example.springcourses.services.GroupService;
import com.example.springcourses.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/courses/{courseId}/groups")
@Controller
public class GroupController {

    private final GroupService groupService;
    private final CourseService courseService;
    private final UserService userService;

    @GetMapping("/find")
    public String getGroups(@PathVariable(name = "courseId") Long courseId, Model model, CourseDto courseDto) {
        List<GroupDto> groupsDto = groupService.findInCourse(courseDto);
        model.addAttribute("selections", groupsDto);
        model.addAttribute("courseDto", courseDto);
        return "groups/index";
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping("/{groupId}/edit")
    public String initUpdating(@PathVariable(name = "groupId") Long groupId, Model model) {
        GroupDto groupDto = groupService.findById(groupId);
        model.addAttribute("groupDto", groupDto);
        return "groups/edition";

    }

    @GetMapping("/{groupId}/students/find")
    public String getStudentsInGroup(@PathVariable(name = "courseId") Long courseId, Model model, GroupDto groupDto, CourseDto courseDto) {
        List<UserDto> userDtos = userService.findUsersInGroup(groupDto);
        model.addAttribute("userDtos", userDtos);
        model.addAttribute("courseDto", courseDto);
        model.addAttribute("groupDto", groupDto);
        return "groups/studentList";
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @PostMapping("/{groupId}/edit")
    public String processUpdating(@PathVariable(name = "groupId") Long groupId, @Valid GroupDto groupDto, BindingResult bindingResult, CourseDto courseDto) {
        if (bindingResult.hasErrors()) {
            return "groups/edition";
        } else {
            groupDto.setGroupId(groupId);
            groupDto.setCourseDto(courseDto);
            groupService.save(groupDto);
            return "redirect:/courses/" + courseDto.getCourseId() + "/groups/find";
        }

    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping("/create")
    public String initCreating(Model model) {
        model.addAttribute("groupDto", GroupDto.builder().build());
        return "groups/creation";
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @PostMapping("/create")
    public String processCreating(@Valid GroupDto groupDto, BindingResult bindingResult, CourseDto courseDto) {
        if (bindingResult.hasErrors()) {
            return "groups/creation";
        } else {
            groupDto.setCourseDto(courseDto);
            groupService.save(groupDto);
            return "redirect:/courses/" + courseDto.getCourseId() + "/groups/find";
        }
    }

    @PreAuthorize("hasAuthority('TEACHER')")
    @GetMapping("/{groupId}/delete")
    public String deleteGroup(@PathVariable(name = "groupId") Long groupId, CourseDto courseDto) {
        groupService.delete(groupId);
        return "redirect:/courses/" + courseDto.getCourseId() + "/groups/find";

    }

    @ModelAttribute("courseDto")
    public CourseDto findCourse(@PathVariable("courseId") Long courseId) {
        return courseService.findById(courseId);
    }
}
