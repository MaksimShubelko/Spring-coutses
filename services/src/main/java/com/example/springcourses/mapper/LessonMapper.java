package com.example.springcourses.mapper;

import com.example.springcourses.dto.GroupDto;
import com.example.springcourses.dto.LessonDto;
import com.example.springcourses.entity.Group;
import com.example.springcourses.entity.Lesson;
import com.example.springcourses.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {GroupMapper.class})
public interface LessonMapper {

    Lesson map(LessonDto dto);

    //@Mapping(target = "teachersDto", source = "teachers", ignore = true)
    LessonDto mapToDto(Lesson entity);
}
