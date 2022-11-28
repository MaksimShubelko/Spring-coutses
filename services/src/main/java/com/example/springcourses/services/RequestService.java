package com.example.springcourses.services;

import com.example.springcourses.dto.RequestDto;
import com.example.springcourses.entity.Request;

import java.security.Principal;

public interface RequestService extends CrudService<RequestDto, Long> {
    default void addRequest(Long courseId, Principal principal) {
        throw new UnsupportedOperationException();
    }
}
