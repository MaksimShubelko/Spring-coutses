package com.example.springcourses.entity;

public class Question implements BaseEntity<Long> {
    private Long questionId;
    private Test test;

    @Override
    public Long getId() {
        return questionId;
    }
}
