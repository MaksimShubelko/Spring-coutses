package com.example.springcourses.services.map;

import com.example.springcourses.dto.LessonDto;
import com.example.springcourses.entity.Lesson;
import com.example.springcourses.services.LessonService;
import com.example.springcourses.services.config.MapImplementation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@MapImplementation
public class LessonMapService extends AbstractMapService<LessonDto, Long> implements LessonService {

    private static final Map<Long, LessonDto> resource = new HashMap<>();

    @Override
    public Map<Long, LessonDto> getResource() {
        return resource;
    }
}
