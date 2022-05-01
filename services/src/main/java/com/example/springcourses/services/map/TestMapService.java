package com.example.springcourses.services.map;

import com.example.springcourses.entity.Test;
import com.example.springcourses.services.TestService;
import com.example.springcourses.services.config.MapImplementation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@MapImplementation
public class TestMapService extends AbstractMapService<Test, Long> implements TestService {
    private static final Map<Long, Test> resource = new HashMap<>();

    @Override
    public Map<Long, Test> getResource() {
        return resource;
    }
}
