package com.example.springcourses.services.map;

import com.example.springcourses.entity.Theme;
import com.example.springcourses.services.ThemeService;
import com.example.springcourses.services.config.MapImplementation;

import java.util.HashMap;
import java.util.Map;

@MapImplementation
public class ThemeMapService extends AbstractMapService<Theme, Long> implements ThemeService {
    private static final Map<Long, Theme> resource = new HashMap<>();


    @Override
    public Map<Long, Theme> getResource() {
        return resource;
    }
}
