package com.example.springcourses.services.jpa;

import com.example.springcourses.dto.*;
import com.example.springcourses.entity.Group;
import com.example.springcourses.mapper.*;
import com.example.springcourses.repository.GroupRepository;
import com.example.springcourses.repository.StudentRepository;
import com.example.springcourses.repository.ThemeRepository;
import com.example.springcourses.services.GroupService;
import com.example.springcourses.services.config.JpaImplementation;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@JpaImplementation
public class GroupJpaService extends AbstractJpaService<GroupDto, Group, Long> implements GroupService {

    private final GroupRepository repository;
    private final GroupMapper mapper;
    private final CourseMapper courseMapper;


    @Override
    public GroupDto findById(Long aLong) {

        return repository
                .findById(aLong)
                .map(mapper::mapToDto)
                .orElseThrow();
    }

    @Override
    public void save(GroupDto dto) {
        repository.save(mapper.map(dto));
    }

    @Override
    public Collection<GroupDto> findAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void delete(Long aLong) {

        repository.deleteById(aLong);
    }

    @Override
    public List<GroupDto> findInCourse(CourseDto courseDto) {
        return repository
                .findAllByCourse(courseMapper.map(courseDto))
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public GroupDto mapToDto(Group entity) {
        return mapper.mapToDto(entity);
    }

    @Override
    public Group mapToEntity(GroupDto dto) {
        return mapper.map(dto);
    }

    @Override
    public JpaRepository<Group, Long> getRepository() {
        return repository;
    }
}
