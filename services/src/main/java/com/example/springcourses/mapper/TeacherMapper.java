package com.example.springcourses.mapper;

import com.example.springcourses.dto.TeacherDto;
import com.example.springcourses.entity.Teacher;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(uses = {LessonMapper.class})
public interface TeacherMapper {

    Teacher map(TeacherDto dto);

    @InheritInverseConfiguration
    TeacherDto mapToDto(Teacher teacher);
}
