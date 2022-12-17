package com.example.springcourses.mapper;

import com.example.springcourses.dto.GroupDto;
import com.example.springcourses.entity.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {StudentMapper.class, ThemeMapper.class})
public interface GroupMapper {


    @Mapping(target = "course", source = "courseDto")
    Group map(GroupDto dto);


    @Mapping(source = "course", target = "courseDto")
    GroupDto mapToDto(Group entity);
}
