package com.example.springcourses.specification.filter;

import com.example.springcourses.entity.Student;
import com.example.springcourses.entity.Student_;
import com.example.springcourses.specification.StudentSpecification;
import lombok.Builder;
import lombok.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

@Builder
@Value
public class StudentFilter implements Filter<Student> {

    private static final Sort DEFAULT_SORTING = Sort.by(Sort.Direction.DESC, Student_.TOTAL_MARK);

    Integer pageNumber;
    String term;

    String firstName;
    String lastName;
    String surname;
    String phoneNumber;
    String email;

    @Override
    public Specification<Student> getSpecification() {
        return StudentSpecification.builder().filter(this).build();
    }

    @Override
    public Pageable getPageable() {
        int page = Objects.isNull(pageNumber) ? 0 : pageNumber - 1;
        return PageRequest.of(page, DEFAULT_PAGE_SIZE, DEFAULT_SORTING);
    }
}
