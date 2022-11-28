package com.example.springcourses.services.impl;

import com.example.springcourses.dto.CorrectAnswerDto;
import com.example.springcourses.dto.GroupDto;
import com.example.springcourses.entity.Group;
import com.example.springcourses.mapper.CorrectAnswerMapper;
import com.example.springcourses.mapper.GroupMapper;
import com.example.springcourses.repository.CorrectAnswerRepository;
import com.example.springcourses.repository.GroupRepository;
import com.example.springcourses.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository repository;
    private final GroupMapper mapper;

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

    @Override
    public void delete(Long aLong) {
        repository.deleteById(aLong);
    }
}
