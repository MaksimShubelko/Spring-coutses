package com.example.springcourses.services.map;

import com.example.springcourses.entity.Teacher;
import com.example.springcourses.services.TeacherService;
import com.example.springcourses.services.config.MapImplementation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@MapImplementation
public class TeacherMapService extends AbstractMapService<Teacher, UUID> implements TeacherService {
    private static final Map<UUID, Teacher> resource = new HashMap<>();

    @Override
    public Map<UUID, Teacher> getResource() {
        return resource;
    }
}
