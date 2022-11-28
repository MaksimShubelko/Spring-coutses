package com.example.springcourses.services.map;

import com.example.springcourses.dto.AcademicPerformanceDto;
import com.example.springcourses.entity.AcademicPerformance;
import com.example.springcourses.services.AcademicPerformanceService;
import com.example.springcourses.services.config.MapImplementation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@MapImplementation
public class AcademicPerformanceMapService extends AbstractMapService<AcademicPerformanceDto, Long>
        implements AcademicPerformanceService {

    private static final Map<Long, AcademicPerformanceDto> resource = new HashMap<>();

    @Override
    public Map<Long, AcademicPerformanceDto> getResource() {
        return resource;
    }
}
