package com.example.springcourses.controller;

import com.example.springcourses.dto.CourseDto;
import com.example.springcourses.dto.GroupDto;
import com.example.springcourses.dto.UserDto;
import com.example.springcourses.services.CourseService;
import com.example.springcourses.services.GroupService;
import com.example.springcourses.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GroupControllerTest {

    @Mock
    private GroupService groupService;

    @Mock
    private CourseService courseService;

    @Mock
    private UserService userService;

    @InjectMocks
    private GroupController groupController;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getGroups() {
        Model model = mock(Model.class);
        CourseDto courseDto = mock(CourseDto.class);

        String result = groupController.getGroups(1L, model, courseDto);

        assertEquals("groups/index", result);
        verify(groupService, times(1)).findInCourse(courseDto);
        verify(model, times(1)).addAttribute(anyString(), anyList());
        verify(model, times(1)).addAttribute("courseDto", courseDto);

    }

    @Test
    void initUpdating() {
        Model model = mock(Model.class);
        GroupDto groupDto = mock(GroupDto.class);

        when(groupService.findById(1L)).thenReturn(groupDto);

        String result = groupController.initUpdating(1L, model);

        assertEquals("groups/edition", result);
        verify(groupService, times(1)).findById(1L);
        verify(model, times(1)).addAttribute("groupDto", groupDto);

    }

    @Test
    void processUpdating() {
        Model model = mock(Model.class);
        CourseDto courseDto = mock(CourseDto.class);
        GroupDto groupDto = mock(GroupDto.class);
        BindingResult bindingResult = mock(BindingResult.class);

        when(bindingResult.hasErrors()).thenReturn(false);
        when(courseDto.getCourseId()).thenReturn(1L);

        String result = groupController.processUpdating(1L, groupDto, bindingResult, courseDto);

        assertEquals("redirect:/courses/1/groups/find", result);
        verify(groupService, times(1)).save(groupDto);
        verify(groupDto, times(1)).setGroupId(anyLong());
        verify(groupDto, times(1)).setCourseDto(courseDto);

    }

    @Test
    void initCreating() {
        Model model = mock(Model.class);
        GroupDto groupDto = mock(GroupDto.class);

        String result = groupController.initCreating(model);

        assertEquals("groups/creation", result);
        verify(model, times(1)).addAttribute(anyString(), any(GroupDto.class));
    }

    @Test
    void processCreating() {
        Model model = mock(Model.class);
        CourseDto courseDto = mock(CourseDto.class);
        GroupDto groupDto = mock(GroupDto.class);
        BindingResult bindingResult = mock(BindingResult.class);

        when(bindingResult.hasErrors()).thenReturn(false);
        when(courseDto.getCourseId()).thenReturn(1L);

        String result = groupController.processCreating(groupDto, bindingResult, courseDto);

        assertEquals("redirect:/courses/1/groups/find", result);
        verify(groupService, times(1)).save(groupDto);
        verify(groupDto, times(1)).setCourseDto(courseDto);
    }

    @Test
    void deleteGroup() {
        CourseDto courseDto = mock(CourseDto.class);

        when(courseDto.getCourseId()).thenReturn(1L);

        String result = groupController.deleteGroup(1L, courseDto);

        assertEquals("redirect:/courses/1/groups/find", result);
        verify(groupService, times(1)).delete(1L);

    }


}