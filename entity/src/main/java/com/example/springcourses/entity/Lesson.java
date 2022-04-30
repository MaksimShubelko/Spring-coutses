package com.example.springcourses.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
