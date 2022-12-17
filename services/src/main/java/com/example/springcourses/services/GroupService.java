package com.example.springcourses.services;

import com.example.springcourses.dto.CourseDto;
import com.example.springcourses.dto.GroupDto;
import com.example.springcourses.entity.Group;

import java.util.List;

public interface GroupService extends CrudService<GroupDto, Long> {

    default List<GroupDto> findInCourse(CourseDto courseDto) {
        throw new UnsupportedOperationException();
    }

    default void createLessons(CourseDto courseDto, GroupDto groupDto) {
        throw new UnsupportedOperationException();
    }

}
