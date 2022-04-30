package com.example.springcourses.services.map;

import com.example.springcourses.entity.Group;

import java.util.HashMap;
import java.util.Map;

public class GroupService extends AbstractMapService<Group, Long> {

    private static final Map<Long, Group> resource = new HashMap<>();

    @Override
    public Map<Long, Group> getResource() {
        return resource;
    }
}
