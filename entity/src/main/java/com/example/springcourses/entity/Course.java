package com.example.springcourses.entity;

import org.springframework.ui.context.Theme;

import java.util.List;

public class Course implements BaseEntity<Long> {
    private Long courseId;
    private String courseName;
    private List<Theme> themes;

    @Override
    public Long getId() {
        return courseId;
    }
}
