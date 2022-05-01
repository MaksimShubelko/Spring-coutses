package com.example.springcourses.services.map;

import com.example.springcourses.entity.Course;
import com.example.springcourses.services.CourseService;
import com.example.springcourses.services.config.MapImplementation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@MapImplementation
public class CourseMapService extends AbstractMapService<Course, Long> implements CourseService {

    private static final Map<Long, Course> resource = new HashMap<>();

    @Override
    public Map<Long, Course> getResource() {
        return resource;
    }
}
