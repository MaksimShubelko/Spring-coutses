package com.example.springcourses.services.map;

import com.example.springcourses.entity.Course;

import java.util.HashMap;
import java.util.Map;

public class CourseService extends AbstractMapService<Course, Long> {

    private static final Map<Long, Course> resource = new HashMap<>();

    @Override
    public Map<Long, Course> getResource() {
        return resource;
    }
}
