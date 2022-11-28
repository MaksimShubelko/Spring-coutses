package com.example.springcourses.specification.filter;

import org.springframework.data.jpa.domain.Specification;

public abstract class SpecBuilder<T, F extends Filter<T>> {

    protected F filter;

    public SpecBuilder<T, F> filter(F filter) {
        this.filter = filter;
        return this;
    }

    public abstract Specification<T> build();

}
