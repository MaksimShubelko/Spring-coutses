package com.example.springcourses.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Answer implements BaseEntity<Long> {
    private Long answerId;
    private Question question;

    @Override
    public Long getId() {
        return answerId;
    }
}
