package com.example.springcourses.mapper;

import com.example.springcourses.dto.StudentDto;
import com.example.springcourses.entity.Student;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(uses = {ReceiptMapper.class, GroupMapper.class})
public interface StudentMapper {

    Student map(StudentDto dto);

    StudentDto mapToDto(Student student);
}
