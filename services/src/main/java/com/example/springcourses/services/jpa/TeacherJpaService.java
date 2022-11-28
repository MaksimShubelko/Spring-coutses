package com.example.springcourses.services.jpa;

import com.example.springcourses.dto.TeacherDto;
import com.example.springcourses.entity.Teacher;
import com.example.springcourses.mapper.TeacherMapper;
import com.example.springcourses.repository.TeacherRepository;
import com.example.springcourses.services.TeacherService;
import com.example.springcourses.services.config.JpaImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@JpaImplementation
public class TeacherJpaService extends AbstractJpaService<TeacherDto, Teacher, Long> implements TeacherService {

    private final TeacherRepository repository;
    private final TeacherMapper mapper;

    @Override
    public TeacherDto findById(Long aLong) {

        return repository
                .findById(aLong)
                .map(mapper::mapToDto)
                .orElseThrow();
    }

    @Override
    public void save(TeacherDto dto) {
        repository.save(mapper.map(dto));
    }

    @Override
    public Collection<TeacherDto> findAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDto findByUserId(Long userId) {
        return mapper.mapToDto(repository.findByUserId(userId));
    }

    @Override
    public void delete(Long aLong) {
        repository.deleteById(aLong);
    }

    @Override
    public TeacherDto mapToDto(Teacher entity) {
        return mapper.mapToDto(entity);
    }

    @Override
    public Teacher mapToEntity(TeacherDto dto) {
        return mapper.map(dto);
    }

    @Override
    public JpaRepository<Teacher, Long> getRepository() {
        return repository;
    }
}
