package com.example.springcourses.entity;

public class Answer implements BaseEntity<Long> {
    private Long answerId;
    private Question question;

    @Override
    public Long getId() {
        return answerId;
    }
}
