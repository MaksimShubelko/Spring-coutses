package com.example.springcourses.services.jpa;

import com.example.springcourses.dto.CourseDto;
import com.example.springcourses.dto.ThemeDto;
import com.example.springcourses.entity.Course;
import com.example.springcourses.mapper.CourseMapper;
import com.example.springcourses.repository.CourseRepository;
import com.example.springcourses.services.CourseService;
import com.example.springcourses.services.config.JpaImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@JpaImplementation
public class CourseJpaService extends AbstractJpaService<CourseDto, Course, Long> implements CourseService {

    private final CourseRepository repository;
    private final CourseMapper mapper;

    @Override
    public CourseDto findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public void save(CourseDto dto) {
        getRepository().save(mapToEntity(dto));
    }

    @Override
    public List<CourseDto> findAll() {
        return getRepository()
                .findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long aLong) {
        getRepository().deleteById(aLong);
    }

    @Override
    public JpaRepository<Course, Long> getRepository() {
        return repository;
    }

    @Override
    public CourseDto mapToDto(Course entity) {
        return mapper.mapToDto(entity);
    }

    @Override
    public Course mapToEntity(CourseDto dto) {
        return mapper.map(dto);
    }
}
