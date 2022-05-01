package com.example.springcourses.services.map;

import com.example.springcourses.entity.Request;
import com.example.springcourses.services.RequestService;
import com.example.springcourses.services.config.MapImplementation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@MapImplementation
public class RequestMapService extends AbstractMapService<Request, Long> implements RequestService {
    private static final Map<Long, Request> resource = new HashMap<>();

    @Override
    public Map<Long, Request> getResource() {
        return resource;
    }
}
