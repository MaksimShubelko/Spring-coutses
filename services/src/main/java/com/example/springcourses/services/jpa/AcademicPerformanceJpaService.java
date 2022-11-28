package com.example.springcourses.services.jpa;

import com.example.springcourses.dto.AcademicPerformanceDto;
import com.example.springcourses.entity.AcademicPerformance;
import com.example.springcourses.mapper.AcademicPerformanceMapper;
import com.example.springcourses.services.AcademicPerformanceService;
import com.example.springcourses.services.config.JpaImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

/*@RequiredArgsConstructor
@JpaImplementation
public class AcademicPerformanceJpaService extends AbstractJpaService<AcademicPerformanceDto, AcademicPerformance, Long> implements AcademicPerformanceService {

    private final AcademicPerformanceMapper mapper;

    @Override
    public JpaRepository<AcademicPerformance, Long> getRepository() {
        throw new UnsupportedOperationException();
    }

    @Override
    public AcademicPerformanceDto mapToDto(AcademicPerformance entity) {
        return null;
    }

    @Override
    public AcademicPerformance mapToEntity(AcademicPerformanceDto dto) {
        return null;
    }
}*/
