package com.example.springcourses.mapper;

import com.example.springcourses.dto.StudentDto;
import com.example.springcourses.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(uses = {GroupMapper.class})
public interface StudentMapper {

    @Mapping(source = "groupDto", target = "group")
    @Mapping(target = "createdBy", source = "createdBy")
    @Mapping(target = "lastModifiedAt", source = "lastModifiedAt", defaultExpression = "java(java.time.OffsetDateTime.now())")
    Student map(StudentDto dto);


    @Mapping(source = "group", target = "groupDto")
    @Mapping(target = "createdBy", source = "createdBy")
    @Mapping(target = "lastModifiedAt", source = "lastModifiedAt", defaultExpression = "java(java.time.OffsetDateTime.now())")
    StudentDto mapToDto(Student student);
}
