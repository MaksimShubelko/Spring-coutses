package com.example.springcourses.services;

import com.example.springcourses.dto.StudentDto;
import com.example.springcourses.entity.Student;
import com.example.springcourses.specification.filter.StudentFilter;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService extends CrudService<StudentDto, Long> {

    default List<StudentDto> findStudent(StudentDto studentDto) {
        throw new UnsupportedOperationException();
    }

    default Page<StudentDto> search(StudentFilter studentFilter) {
        throw new UnsupportedOperationException();
    }
}
