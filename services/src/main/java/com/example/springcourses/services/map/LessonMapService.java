package com.example.springcourses.services.map;

import com.example.springcourses.entity.Lesson;
import com.example.springcourses.services.LessonService;

import java.util.HashMap;
import java.util.Map;

public class LessonMapService extends AbstractMapService<Lesson, Long> implements LessonService {

    private static final Map<Long, Lesson> resource = new HashMap<>();

    @Override
    public Map<Long, Lesson> getResource() {
        return resource;
    }
}
