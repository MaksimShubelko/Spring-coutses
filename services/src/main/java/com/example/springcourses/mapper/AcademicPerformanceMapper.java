package com.example.springcourses.mapper;

import com.example.springcourses.dto.AcademicPerformanceDto;
import com.example.springcourses.entity.AcademicPerformance;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {StudentMapper.class, AnswerMapper.class})
public interface AcademicPerformanceMapper {

    AcademicPerformance map(AcademicPerformanceDto dto);

    AcademicPerformanceDto mapToDto(AcademicPerformance entity);

}
