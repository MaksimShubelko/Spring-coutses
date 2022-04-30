package com.example.springcourses.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Lesson implements BaseEntity<Long> {
    private Long lessonId;
    private LocalDateTime date;
    private Group group;
    private List<Teacher> teachers;
    private String theme;

    @Override
    public Long getId() {
        return lessonId;
    }
}
