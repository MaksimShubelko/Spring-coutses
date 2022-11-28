package com.example.springcourses.dto;

import com.example.springcourses.entity.AcademicPerformance;
import com.example.springcourses.entity.Question;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AnswerDto {

    private Long answerId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private QuestionDto questionDto;
    private OffsetDateTime date;
    private String answer;
    private AcademicPerformanceDto academicPerformanceDto;
}
