package com.example.springcourses.services.map;

import com.example.springcourses.entity.Teacher;

import java.util.HashMap;
import java.util.Map;

public class TeacherMapService extends AbstractMapService<Teacher, Long> {
    private static final Map<Long, Teacher> resource = new HashMap<>();

    @Override
    public Map<Long, Teacher> getResource() {
        return resource;
    }
}
