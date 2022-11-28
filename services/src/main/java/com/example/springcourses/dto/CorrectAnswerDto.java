package com.example.springcourses.dto;

import com.example.springcourses.entity.Question;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CorrectAnswerDto {

    private Long correctAnswerId;
    private QuestionDto questionDto;
    private String correctAnswer;
}
