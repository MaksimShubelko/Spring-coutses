package com.example.springcourses.entity;

import javax.persistence.Entity;
import java.util.List;

public class Group implements BaseEntity<Long> {
    private Long groupId;
    private List<Student> students;
    private String description;
    private List<Test> tests;

    @Override
    public Long getId() {
        return groupId;
    }
}
