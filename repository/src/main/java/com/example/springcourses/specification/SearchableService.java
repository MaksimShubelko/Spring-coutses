package com.example.springcourses.specification;

import com.example.springcourses.specification.filter.Filter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Objects;

public interface SearchableService<T> {

    SearchableRepository<T, ?> getSearchRepository();

    default <F extends Filter<T>> List<T> searchList(F filter) {
        Specification<T> specification = filter.getSpecification();
        if (Objects.isNull(specification)) {
            return getSearchRepository().findAll();
        }
        return getSearchRepository().findAll(specification);
    }

    default <F extends Filter<T>> Page<T> searchPage(F filter) {
        System.out.println("Filter " + filter);
        Specification<T> specification = filter.getSpecification();
        Pageable pageable = filter.getPageable();
        if (Objects.isNull(specification)) {
            return getSearchRepository().findAll(pageable);
        }
        return getSearchRepository().findAll(specification, pageable);
    }

}
