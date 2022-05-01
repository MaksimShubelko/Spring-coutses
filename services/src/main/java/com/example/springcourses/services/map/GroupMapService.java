package com.example.springcourses.services.map;

import com.example.springcourses.entity.Group;
import com.example.springcourses.services.GroupService;
import com.example.springcourses.services.config.MapImplementation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@MapImplementation
public class GroupMapService extends AbstractMapService<Group, Long> implements GroupService {

    private static final Map<Long, Group> resource = new HashMap<>();

    @Override
    public Map<Long, Group> getResource() {
        return resource;
    }
}
