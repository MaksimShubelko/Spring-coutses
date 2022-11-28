package com.example.springcourses.services;

import com.example.springcourses.dto.SystemLogDto;
import com.example.springcourses.dto.SystemOptionDto;

import java.util.List;

public interface SystemLogService {

    List<SystemLogDto> getAll();

    void createLogs(String activity, String message);

}
