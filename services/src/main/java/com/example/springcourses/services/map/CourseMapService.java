package com.example.springcourses.services.map;

import com.example.springcourses.dto.CourseDto;
import com.example.springcourses.services.CourseService;
import com.example.springcourses.services.config.MapImplementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@MapImplementation
public class CourseMapService extends AbstractMapService<CourseDto, Long> implements CourseService {

    private static final Map<Long, CourseDto> resource = new HashMap<>();

    @Override
    public Map<Long, CourseDto> getResource() {
        return resource;
    }

    @Override
    public CourseDto findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public void save(CourseDto entity) {
        super.save(entity);
    }

    @Override
    public List<CourseDto> findAll() {
        return (List<CourseDto>) super.findAll();
    }

    @Override
    public void delete(Long aLong) {
        super.delete(aLong);
    }
}
