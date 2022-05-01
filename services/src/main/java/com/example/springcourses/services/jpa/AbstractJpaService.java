package com.example.springcourses.services.jpa;

import com.example.springcourses.entity.BaseEntity;
import com.example.springcourses.services.BaseJpaService;
import com.example.springcourses.services.CrudService;

import java.util.Collection;
import java.util.Collections;
import java.util.NoSuchElementException;

public abstract class AbstractJpaService<T extends BaseEntity<ID>, ID> implements CrudService<T, ID>, BaseJpaService<T, ID> {
    @Override
    public T findById(ID id) {

        return getRepository().findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void save(T entity) {

        getRepository().save(entity);
    }

    @Override
    public Collection<T> findAll() {

        return getRepository().findAll();
    }

    @Override
    public void delete(ID id) {

        getRepository().deleteById(id);
    }
}
