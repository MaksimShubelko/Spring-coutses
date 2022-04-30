package com.example.springcourses.services.map;

import com.example.springcourses.entity.Request;

import java.util.HashMap;
import java.util.Map;

public class RequestMapService extends AbstractMapService<Request, Long> {
    private static final Map<Long, Request> resource = new HashMap<>();

    @Override
    public Map<Long, Request> getResource() {
        return resource;
    }
}
