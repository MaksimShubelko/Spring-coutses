package com.example.springcourses.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
