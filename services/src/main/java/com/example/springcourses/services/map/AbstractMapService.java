package com.example.springcourses.services.map;

import com.example.springcourses.entity.BaseEntity;
import com.example.springcourses.services.BaseMapService;
import com.example.springcourses.services.CrudService;

import java.util.Collection;

public abstract class AbstractMapService<D, ID> implements CrudService<D, ID>, BaseMapService<D, ID> {
    @Override
    public D findById(ID id) {
        return getResource().get(id);
    }

    @Override
    public void save(D entity) {
        //getResource().put(entity., entity);
    }

    @Override
    public Collection<D> findAll() {
        return getResource().values();
    }

    @Override
    public void delete(ID id) {
        getResource().remove(id);
    }
}
