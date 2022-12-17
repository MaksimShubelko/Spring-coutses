package com.example.springcourses.services;

import com.example.springcourses.dto.CourseDto;
import com.example.springcourses.dto.ThemeDto;
import com.example.springcourses.entity.Theme;

public interface ThemeService extends CrudService<ThemeDto, Long> {

    default void delete(Long aLong) {
        throw new UnsupportedOperationException();
    }

}
