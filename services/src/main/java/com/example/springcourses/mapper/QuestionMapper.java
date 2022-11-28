package com.example.springcourses.mapper;

import com.example.springcourses.dto.QuestionDto;
import com.example.springcourses.entity.Question;
import org.mapstruct.Mapper;

@Mapper(uses = {AnswerMapper.class, CorrectAnswerMapper.class})
public interface QuestionMapper {

    Question map(QuestionDto dto);

    QuestionDto mapToDto(Question entity);
}
