package com.example.springcourses.dto;

import com.example.springcourses.entity.Course;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ThemeDto {

    private Long themeId;
    @Pattern(regexp = ".{3,50}", message = "The length should be from 3 to 50")
    private String description;
    private CourseDto courseDto;

}
