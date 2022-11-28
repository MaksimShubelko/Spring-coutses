package com.example.springcourses.mapper;

import com.example.springcourses.dto.TeacherDto;
import com.example.springcourses.dto.TestDto;
import com.example.springcourses.entity.Teacher;
import com.example.springcourses.entity.Test;
import org.mapstruct.Mapper;

@Mapper(uses = {AcademicPerformanceMapper.class, QuestionMapper.class})
public interface TestMapper {

    Test map(TestDto dto);

    TestDto mapToDto(Test student);
}
