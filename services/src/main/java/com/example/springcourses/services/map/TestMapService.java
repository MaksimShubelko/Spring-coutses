package com.example.springcourses.services.map;

import com.example.springcourses.entity.Test;
import com.example.springcourses.services.TestService;

import java.util.HashMap;
import java.util.Map;

public class TestMapService extends AbstractMapService<Test, Long> implements TestService {
    private static final Map<Long, Test> resource = new HashMap<>();

    @Override
    public Map<Long, Test> getResource() {
        return resource;
    }
}
