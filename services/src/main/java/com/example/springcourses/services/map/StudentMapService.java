package com.example.springcourses.services.map;

import com.example.springcourses.entity.Student;
import com.example.springcourses.services.StudentService;
import com.example.springcourses.services.config.MapImplementation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@MapImplementation
public class StudentMapService extends AbstractMapService<Student, UUID> implements StudentService {
    private static final Map<UUID, Student> resource = new HashMap<>();

    @Override
    public Map<UUID, Student> getResource() {
        return resource;
    }
}
