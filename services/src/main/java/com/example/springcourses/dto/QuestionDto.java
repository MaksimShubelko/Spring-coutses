package com.example.springcourses.dto;

import com.example.springcourses.entity.Answer;
import com.example.springcourses.entity.CorrectAnswer;
import com.example.springcourses.entity.Test;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class QuestionDto {

    private Long questionId;
    private AnswerDto answerDto;
    private TestDto testDto;
    private CorrectAnswerDto correctAnswerDto;
}
