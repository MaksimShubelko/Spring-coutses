package com.example.springcourses.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Teacher implements BaseEntity<Long> {
    private Long teacherId;
    private User user;
    private String description;

    @Override
    public Long getId() {
        return teacherId;
    }
}
