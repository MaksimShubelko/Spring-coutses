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
public class Test implements BaseEntity<Long> {
    private Long testId;
    private List<Question> questions;
    private Group group;

    @Override
    public Long getId() {
        return testId;
    }
}
