package com.example.springcourses.dto;

import com.example.springcourses.entity.Group;
import com.example.springcourses.entity.Teacher;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class LessonDto {

    private Long lessonId;
    private LocalDateTime date;
    private GroupDto groupDto;
    private List<TeacherDto> teachersDto;
    private String theme;
}
