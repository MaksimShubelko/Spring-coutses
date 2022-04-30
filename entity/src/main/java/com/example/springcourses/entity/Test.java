package com.example.springcourses.entity;

import java.util.List;

public class Test implements BaseEntity<Long> {
    private Long testId;
    private List<Question> questions;
    private Group group;

    @Override
    public Long getId() {
        return testId;
    }
}
