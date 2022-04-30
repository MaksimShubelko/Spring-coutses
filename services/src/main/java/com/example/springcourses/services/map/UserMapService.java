package com.example.springcourses.services.map;

import com.example.springcourses.entity.User;
import com.example.springcourses.services.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserMapService extends AbstractMapService<User, UUID> implements UserService {

    private static final Map<UUID, User> resource = new HashMap<>();

    @Override
    public Map<UUID, User> getResource() {
        return resource;
    }
}
