package com.example.springcourses.services;


import java.util.Map;

public interface BaseMapService<T, ID> {

    Map<ID, T> getResource();
}
