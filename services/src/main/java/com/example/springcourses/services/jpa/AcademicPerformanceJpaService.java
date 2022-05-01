package com.example.springcourses.services.jpa;

import com.example.springcourses.entity.AcademicPerformance;
import com.example.springcourses.services.AcademicPerformanceService;
import com.example.springcourses.services.config.JpaImplementation;
import org.springframework.data.jpa.repository.JpaRepository;

@JpaImplementation
public class AcademicPerformanceJpaService extends AbstractJpaService<AcademicPerformance, Long> implements AcademicPerformanceService {
    @Override
    public JpaRepository<AcademicPerformance, Long> getRepository() {
        throw new UnsupportedOperationException();
    }
}
