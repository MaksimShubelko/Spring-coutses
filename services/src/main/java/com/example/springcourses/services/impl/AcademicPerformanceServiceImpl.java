package com.example.springcourses.services.impl;

import com.example.springcourses.dto.AcademicPerformanceDto;
import com.example.springcourses.mapper.AcademicPerformanceMapper;
import com.example.springcourses.repository.AcademicPerformanceRepository;
import com.example.springcourses.services.AcademicPerformanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AcademicPerformanceServiceImpl implements AcademicPerformanceService {

    private final AcademicPerformanceRepository repository;
    private final AcademicPerformanceMapper mapper;

    @Override
    public AcademicPerformanceDto findById(Long aLong) {

        return repository
                .findById(aLong)
                .map(mapper::mapToDto)
                .orElseThrow();
    }

    @Override
    public void save(AcademicPerformanceDto dto) {
        repository.save(mapper.map(dto));
    }

    @Override
    public Collection<AcademicPerformanceDto> findAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long aLong) {
        repository.deleteById(aLong);
    }
}
