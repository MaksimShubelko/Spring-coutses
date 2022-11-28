package com.example.springcourses.dto;

import com.example.springcourses.entity.Answer;
import com.example.springcourses.entity.Student;
import com.example.springcourses.entity.Test;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AcademicPerformanceDto {

    private Long academicPerformanceId;
    private Test test;
    private Double mark;
    private StudentDto studentDto;
    private LocalDateTime timeOfPassed;
    private List<AnswerDto> answers;
}
