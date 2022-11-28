package com.example.springcourses.services.map;

import com.example.springcourses.dto.TestDto;
import com.example.springcourses.entity.Test;
import com.example.springcourses.services.TestService;
import com.example.springcourses.services.config.MapImplementation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@MapImplementation
public class TestMapService extends AbstractMapService<TestDto, Long> implements TestService {
    private static final Map<Long, TestDto> resource = new HashMap<>();

    @Override
    public Map<Long, TestDto> getResource() {
        return resource;
    }
}
