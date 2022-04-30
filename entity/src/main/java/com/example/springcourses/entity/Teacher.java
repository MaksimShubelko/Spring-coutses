package com.example.springcourses.entity;

public class Teacher implements BaseEntity<Long> {
    private Long teacherId;
    private User user;

    @Override
    public Long getId() {
        return teacherId;
    }
}
