package com.example.springcourses.services.map;

import com.example.springcourses.dto.ThemeDto;
import com.example.springcourses.entity.Theme;
import com.example.springcourses.services.ThemeService;
import com.example.springcourses.services.config.MapImplementation;

import java.util.HashMap;
import java.util.Map;

@MapImplementation
public class ThemeMapService extends AbstractMapService<ThemeDto, Long> implements ThemeService {
    private static final Map<Long, ThemeDto> resource = new HashMap<>();


    @Override
    public Map<Long, ThemeDto> getResource() {
        return resource;
    }
}
