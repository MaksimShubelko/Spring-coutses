package com.example.springcourses.services.map;

import com.example.springcourses.dto.GroupDto;
import com.example.springcourses.entity.Group;
import com.example.springcourses.services.GroupService;
import com.example.springcourses.services.config.MapImplementation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@MapImplementation
public class GroupMapService extends AbstractMapService<GroupDto, Long> implements GroupService {

    private static final Map<Long, GroupDto> resource = new HashMap<>();

    @Override
    public Map<Long, GroupDto> getResource() {
        return resource;
    }
}
