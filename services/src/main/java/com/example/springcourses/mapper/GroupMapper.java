package com.example.springcourses.mapper;

import com.example.springcourses.dto.GroupDto;
import com.example.springcourses.entity.Group;
import org.mapstruct.Mapper;

@Mapper(uses = {StudentMapper.class, ThemeMapper.class, TestMapper.class})
public interface GroupMapper {

    Group map(GroupDto dto);

    GroupDto mapToDto(Group entity);
}
