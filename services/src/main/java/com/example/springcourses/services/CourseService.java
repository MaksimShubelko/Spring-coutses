package com.example.springcourses.services;

import com.example.springcourses.dto.CourseDto;
import com.example.springcourses.dto.ThemeDto;
import com.example.springcourses.entity.Course;

import java.util.List;

public interface CourseService extends CrudService<CourseDto, Long> {

    default List<CourseDto> findAll() {
        throw new UnsupportedOperationException();
    }

    default void updateTheme(ThemeDto themeDto, Long courseId) {
        throw new UnsupportedOperationException();
    }
}
