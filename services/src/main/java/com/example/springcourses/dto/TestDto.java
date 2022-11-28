package com.example.springcourses.dto;

import com.example.springcourses.entity.Group;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class TestDto {

    private Long testId;
    private List<QuestionDto> questionsDto;
    private Group group;
    private List<AcademicPerformanceDto> academicPerformancesDto;
}
