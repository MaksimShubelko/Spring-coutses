package com.example.springcourses.services.impl;

import com.example.listener.AuditLogService;
import com.example.springcourses.dto.SystemLogDto;
import com.example.springcourses.dto.SystemOptionDto;
import com.example.springcourses.mapper.SystemLogMapper;
import com.example.springcourses.services.SystemLogService;
import com.example.system.entity.SystemLogEntity;
import com.example.system.repository.SystemLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SystemLogServiceImpl implements SystemLogService, AuditLogService {

    @Lazy
    @Autowired
    private SystemLogRepository systemLogRepository;
    private final SystemLogMapper mapper;

    @Override
    public List<SystemLogDto> getAll() {
        return mapper.mapListToDto(systemLogRepository.findAll());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, transactionManager = "systemTransactionManager")
    @Override
    public void createLogs(String activity, String message) {
        systemLogRepository.save(SystemLogEntity.builder()
                .activity(activity)
                .message(message)
                .build());
    }

}
