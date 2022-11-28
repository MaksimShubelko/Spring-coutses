package com.example.springcourses.services.map;

import com.example.springcourses.dto.UserDto;
import com.example.springcourses.services.UserService;
import com.example.springcourses.services.config.MapImplementation;

import java.util.HashMap;
import java.util.Map;

@MapImplementation
public class UserMapService extends AbstractMapService<UserDto, Long> implements UserService {
    private static final Map<UserDto, Long> resource = new HashMap<>();


    @Override
    public Map<Long, UserDto> getResource() {
        return null;
    }
}
