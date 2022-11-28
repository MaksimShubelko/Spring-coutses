package com.example.springcourses.mapper;

import com.example.springcourses.dto.AnswerDto;
import com.example.springcourses.entity.Answer;
import org.mapstruct.Mapper;

@Mapper(uses = {QuestionMapper.class, AcademicPerformanceMapper.class})
public interface AnswerMapper {

    Answer map(AnswerDto dto);

    AnswerDto mapToDto(Answer entity);
}
