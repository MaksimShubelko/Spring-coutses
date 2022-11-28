package com.example.springcourses.specification.filter;

import com.example.springcourses.entity.UserEntity;
import com.example.springcourses.entity.UserEntity_;
import com.example.springcourses.specification.UserSpecification;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

@Getter
@Setter
@Builder
public class UserFilter implements Filter<UserEntity> {

    private static final Sort DEFAULT_SORTING = Sort.by(Sort.Direction.DESC, UserEntity_.SURNAME);

    Integer pageNumber;
    String term;

    String firstName;
    String lastName;
    String surname;
    String phoneNumber;
    String email;

    @Override
    public Specification<UserEntity> getSpecification() {
        return UserSpecification.builder().filter(this).build();
    }

    @Override
    public Pageable getPageable() {
        int page = Objects.isNull(pageNumber) ? 0 : pageNumber - 1;
        return PageRequest.of(page, DEFAULT_PAGE_SIZE, DEFAULT_SORTING);
    }
}
