package com.example.springcourses.services;

import java.util.Collection;

public interface CrudService<T, ID> {
    T findById(ID id);

    void save(T entity);

    Collection<T> findAll();

    void delete(ID id);
}
