package com.example.springcourses.mapper;

import com.example.springcourses.dto.CorrectAnswerDto;
import com.example.springcourses.entity.CorrectAnswer;
import org.mapstruct.Mapper;

@Mapper(uses = {QuestionMapper.class})
public interface CorrectAnswerMapper {

    CorrectAnswer map(CorrectAnswerDto dto);

    CorrectAnswerDto mapToDto(CorrectAnswer entity);
}
