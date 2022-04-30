package com.example.springcourses.services.map;

import com.example.springcourses.entity.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentMapService extends AbstractMapService<Student, Long> {
    private static final Map<Long, Student> resource = new HashMap<>();

    @Override
    public Map<Long, Student> getResource() {
        return resource;
    }
}
