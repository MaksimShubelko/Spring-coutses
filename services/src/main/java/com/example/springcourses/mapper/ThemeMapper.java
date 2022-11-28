package com.example.springcourses.mapper;

import com.example.springcourses.dto.ThemeDto;
import com.example.springcourses.entity.Theme;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ThemeMapper {

    @Mapping(source = "courseDto", target = "course")
    Theme map(ThemeDto dto);

    @Mapping(target = "courseDto", source = "course")
    ThemeDto mapToDto(Theme student);
}
