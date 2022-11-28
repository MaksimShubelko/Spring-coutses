package com.example.springcourses.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class GroupDto {

    private Long groupId;
    private List<StudentDto> studentsDto;
    private List<LessonDto> lessonsDto;
    private String description;
    private List<TestDto> testsDto;

}
