package com.example.springcourses.mapper;

import com.example.springcourses.dto.CourseDto;
import com.example.springcourses.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(uses = {ThemeMapper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public interface CourseMapper {

    @Mapping(source = "themesDto", target = "themes")
    Course map(CourseDto dto);

    @Mapping(source = "themes", target = "themesDto")
    CourseDto mapToDto(Course entity);
}
