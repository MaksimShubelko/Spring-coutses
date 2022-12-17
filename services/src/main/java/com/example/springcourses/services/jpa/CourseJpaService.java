package com.example.springcourses.services.jpa;

import com.example.springcourses.dto.CourseDto;
import com.example.springcourses.dto.GroupDto;
import com.example.springcourses.dto.ThemeDto;
import com.example.springcourses.entity.Course;
import com.example.springcourses.mapper.CourseMapper;
import com.example.springcourses.mapper.GroupMapper;
import com.example.springcourses.mapper.ThemeMapper;
import com.example.springcourses.repository.CourseRepository;
import com.example.springcourses.repository.GroupRepository;
import com.example.springcourses.repository.ThemeRepository;
import com.example.springcourses.services.CourseService;
import com.example.springcourses.services.config.JpaImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@JpaImplementation
public class CourseJpaService extends AbstractJpaService<CourseDto, Course, Long> implements CourseService {

    private final CourseRepository repository;
    private final CourseMapper mapper;
    private final GroupRepository groupRepository;
    private final ThemeRepository themeRepository;

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

    @Transactional
    @Override
    public void delete(Long aLong) {
        groupRepository.deleteByCourse(aLong);
        themeRepository.deleteByCourseId(aLong);
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
