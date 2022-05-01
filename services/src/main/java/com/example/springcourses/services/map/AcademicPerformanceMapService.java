package com.example.springcourses.services.map;

import com.example.springcourses.entity.AcademicPerformance;
import com.example.springcourses.services.AcademicPerformanceService;
import com.example.springcourses.services.config.MapImplementation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@MapImplementation
public class AcademicPerformanceMapService extends AbstractMapService<AcademicPerformance, Long>
        implements AcademicPerformanceService {

    private static final Map<Long, AcademicPerformance> resource = new HashMap<>();

    @Override
    public Map<Long, AcademicPerformance> getResource() {
        return resource;
    }
}
