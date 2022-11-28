package com.example.springcourses.dto;

import com.example.springcourses.entity.Course;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ThemeDto {

    private Long themeId;
    private String description;
    private CourseDto courseDto;
}
