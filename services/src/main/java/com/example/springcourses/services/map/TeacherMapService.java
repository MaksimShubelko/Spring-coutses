package com.example.springcourses.services.map;

import com.example.springcourses.entity.Teacher;
import com.example.springcourses.services.TeacherService;
import com.example.springcourses.services.config.MapImplementation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@MapImplementation
public class TeacherMapService extends AbstractMapService<Teacher, Long> implements TeacherService {
    private static final Map<Long, Teacher> resource = new HashMap<>();

    @Override
    public Map<Long, Teacher> getResource() {
        return resource;
    }
}
