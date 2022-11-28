package com.example.springcourses.services.map;

import com.example.springcourses.dto.StudentDto;
import com.example.springcourses.entity.Student;
import com.example.springcourses.services.StudentService;
import com.example.springcourses.services.config.MapImplementation;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@MapImplementation
public class StudentMapService extends AbstractMapService<StudentDto, Long> implements StudentService {
    private static final Map<Long, StudentDto> resource = new HashMap<>();

    @Override
    public Map<Long, StudentDto> getResource() {
        return resource;
    }
}
