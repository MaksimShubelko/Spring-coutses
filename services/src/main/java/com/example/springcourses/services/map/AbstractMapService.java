package com.example.springcourses.services.map;

import com.example.springcourses.entity.BaseEntity;
import com.example.springcourses.services.BaseMapService;
import com.example.springcourses.services.CrudService;

import java.util.Collection;

public abstract class AbstractMapService<T extends BaseEntity<ID>, ID> implements CrudService<T, ID>, BaseMapService<T, ID> {
    @Override
    public T findById(ID id) {
        return getResource().get(id);
    }

    @Override
    public void save(T entity) {
        getResource().put(entity.getId(), entity);
    }

    @Override
    public Collection<T> findAll() {
        return getResource().values();
    }

    @Override
    public void delete(ID id) {
        getResource().remove(id);
    }
}
