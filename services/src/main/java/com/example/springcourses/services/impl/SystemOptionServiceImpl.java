package com.example.springcourses.services.impl;

import com.example.springcourses.dto.SystemOptionDto;
import com.example.springcourses.mapper.SystemOptionMapper;
import com.example.springcourses.services.SystemOptionService;
import com.example.system.entity.SystemOptionEntity;
import com.example.system.repository.SystemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SystemOptionServiceImpl implements SystemOptionService {

    private final SystemRepository systemRepository;
    private final SystemOptionMapper systemOptionMapper;

    @Override
    public List<SystemOptionDto> getAll() {
        return systemOptionMapper.mapListToDto(systemRepository.findAll());
    }

    @Transactional(transactionManager = "systemTransactionManager")
    @Override
    public void save(SystemOptionDto option) {
        SystemOptionEntity entity = systemRepository.findById(option.getId())
                .orElse(SystemOptionEntity.builder().id(option.getId()).build());
        entity.setValue(option.getValue());
        systemRepository.save(entity);
    }

    @Override
    public SystemOptionDto getById(String optionKey) {
        return systemRepository.findById(optionKey).map(systemOptionMapper::mapToDto).orElseThrow();
    }
}
