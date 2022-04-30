package com.example.springcourses.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.ui.context.Theme;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course implements BaseEntity<Long> {
    private Long courseId;
    private String courseName;
    private List<Theme> themes;

    @Override
    public Long getId() {
        return courseId;
    }
}
