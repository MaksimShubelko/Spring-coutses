package com.example.springcourses.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Question implements BaseEntity<Long> {
    private Long questionId;
    private Test test;

    @Override
    public Long getId() {
        return questionId;
    }
}
