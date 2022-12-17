package com.example.springcourses.services;

import com.example.springcourses.dto.CourseDto;
import com.example.springcourses.dto.GroupDto;
import com.example.springcourses.dto.RequestDto;
import com.example.springcourses.entity.Request;

import java.security.Principal;
import java.util.List;

public interface RequestService extends CrudService<RequestDto, Long> {

    default void addRequest(Long courseId, Principal principal) {
        throw new UnsupportedOperationException();
    }

    default List<RequestDto> findNewByCourse(CourseDto courseDto) {
        throw new UnsupportedOperationException();
    }

    default void addStudentToGroup(GroupDto groupDto, Long requestId) {
        throw new UnsupportedOperationException();
    }
}
