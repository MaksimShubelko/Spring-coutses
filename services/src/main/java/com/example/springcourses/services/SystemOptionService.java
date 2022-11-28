package com.example.springcourses.services;

import com.example.springcourses.dto.SystemOptionDto;

import java.util.List;

public interface SystemOptionService {

    List<SystemOptionDto> getAll();

    void save(SystemOptionDto option);

    SystemOptionDto getById(String optionKey);
}
