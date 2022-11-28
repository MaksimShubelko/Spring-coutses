package com.example.springcourses.mapper;

import com.example.springcourses.dto.CourseDto;
import com.example.springcourses.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {ThemeMapper.class})
public interface CourseMapper {

    @Mapping(source = "themesDto", target = "themes")
    Course map(CourseDto dto);

    @Mapping(source = "themes", target = "themesDto")
    CourseDto mapToDto(Course entity);
}
