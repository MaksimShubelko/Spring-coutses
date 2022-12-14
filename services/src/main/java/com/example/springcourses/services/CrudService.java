package com.example.springcourses.services;

import java.util.Collection;

public interface CrudService<D, ID> {
    D findById(ID id);

    void save(D entity);

    Collection<D> findAll();

    void delete(ID id);
}
