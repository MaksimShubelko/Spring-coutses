package com.example.springcourses.entity;

import java.util.List;

public class CorrectAnswer implements BaseEntity<Long> {
    private Long correctAnswerId;
    private String answers;
    private Question question;

    @Override
    public Long getId() {
        return correctAnswerId;
    }
}
