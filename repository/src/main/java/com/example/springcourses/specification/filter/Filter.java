package com.example.springcourses.specification.filter;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface Filter<T> {

    int DEFAULT_PAGE_SIZE = 10;

    Specification<T> getSpecification();

    default Pageable getPageable() {
        return PageRequest.of(0, DEFAULT_PAGE_SIZE);
    }
}
