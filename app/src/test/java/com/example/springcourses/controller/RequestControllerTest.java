package com.example.springcourses.controller;

import com.example.springcourses.dto.CourseDto;
import com.example.springcourses.dto.GroupDto;
import com.example.springcourses.dto.RequestDto;
import com.example.springcourses.services.CourseService;
import com.example.springcourses.services.GroupService;
import com.example.springcourses.services.RequestService;
import com.example.springcourses.services.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RequestControllerTest {

    @Mock
    private RequestService requestService;

    @Mock
    private GroupService groupService;

    @Mock
    private CourseService courseService;

    @Mock
    private StudentService studentService;

    @InjectMocks
    private RequestController requestController;

    @Test
    void findRequests() {
        CourseDto courseDto = mock(CourseDto.class);
        RequestDto requestDto = mock(RequestDto.class);
        Model model = mock(Model.class);
        when(requestService.findNewByCourse(courseDto)).thenReturn(anyList());

        String result = requestController.findRequests(courseDto, model);

        assertEquals("requests/index", result);
        verify(requestService, times(1)).findNewByCourse(courseDto);
        verify(model, times(1)).addAttribute(anyString(), anyList());
    }

    @Test
    void initApproving() {
        CourseDto courseDto = mock(CourseDto.class);
        GroupDto groupDto = mock(GroupDto.class);

        when(courseDto.getCourseId()).thenReturn(1L);
        when(groupDto.getGroupId()).thenReturn(1L);

        String result = requestController.initApproving(1L, courseDto, groupDto);


        assertEquals("redirect:/courses/1/groups/1/requests/find", result);
        verify(requestService, times(1)).addStudentToGroup(groupDto, 1L);
        verify(courseDto, times(1)).getCourseId();
        verify(groupDto, times(1)).getGroupId();
    }

}