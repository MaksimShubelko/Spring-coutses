package com.example.springcourses.services;

import com.example.springcourses.dto.TeacherDto;

public interface TeacherService extends CrudService<TeacherDto, Long> {

    default TeacherDto findByUserId(Long userId) {
        throw new UnsupportedOperationException();
    }
}
