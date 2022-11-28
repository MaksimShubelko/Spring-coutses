package com.example.springcourses.specification;

import com.example.springcourses.entity.Student;
import com.example.springcourses.entity.UserEntity_;
import com.example.springcourses.specification.filter.SpecBuilder;
import com.example.springcourses.specification.filter.StudentFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


public interface StudentSpecification extends Specification<Student> {

    static StudentSpecification hasFirstName(String value) {
        return (root, cq, cb) -> cb.equal(cb.lower(root.get(UserEntity_.FIRST_NAME)), value.toLowerCase());

    }

    static StudentSpecification hasLastName(String value) {
        return (root, cq, cb) -> cb.equal(cb.lower(root.get(UserEntity_.LAST_NAME)), value.toLowerCase());

    }

    static StudentSpecification hasSurname(String value) {
        return (root, cq, cb) -> cb.equal(cb.lower(root.get(UserEntity_.SURNAME)), value.toLowerCase());
    }

    static StudentSpecification hasPhoneNumber(String value) {
        return (root, cq, cb) -> cb.equal(cb.lower(root.get(UserEntity_.PHONE_NUMBER)), "%" + value.toLowerCase() + "%");
    }

    static StudentSpecification hasEmail(String value) {
        return (root, cq, cb) -> cb.equal(cb.lower(root.get(UserEntity_.EMAIL)), value.toLowerCase());
    }

    static StudentSpecification firstNameLike(String value) {
        return (root, cq, cb) -> cb.like(cb.lower(root.get(UserEntity_.FIRST_NAME)), "%" + value.toLowerCase() + "%");

    }

    static StudentSpecification lastNameLike(String value) {
        return (root, cq, cb) -> cb.like(cb.lower(root.get(UserEntity_.LAST_NAME)), "%" + value.toLowerCase() + "%");

    }

    static StudentSpecification surnameLike(String value) {
        return (root, cq, cb) -> cb.like(cb.lower(root.get(UserEntity_.SURNAME)), "%" + value.toLowerCase() + "%");
    }

    static StudentSpecification phoneNumberLike(String value) {
        return (root, cq, cb) -> cb.like(cb.lower(root.get(UserEntity_.PHONE_NUMBER)), "%" + value.toLowerCase() + "%");
    }

    static StudentSpecification emailLike(String value) {
        return (root, cq, cb) -> cb.like(cb.lower(root.get(UserEntity_.EMAIL)), "%" + value.toLowerCase() + "%");
    }

    static Specification<Student> findByTerm(String term) {
        List<Specification<Student>> specList = new ArrayList<>();
        specList.add(firstNameLike(term));
        specList.add(lastNameLike(term));
        specList.add(surnameLike(term));
        specList.add(phoneNumberLike(term));
        specList.add(emailLike(term));

        return SpecificationComposer.compose(specList, Predicate.BooleanOperator.OR);
    }

    static StudentSpecification.Builder builder() {
        return new StudentSpecification.Builder();
    }

    class Builder extends SpecBuilder<Student, StudentFilter> {
        @Override
        public Specification<Student> build() {
            List<Specification<Student>> specList = new ArrayList<>();

            if (StringUtils.isNotEmpty(filter.getFirstName())) {
                specList.add(hasFirstName(filter.getFirstName()));
            }
            if (StringUtils.isNotEmpty(filter.getLastName())) {
                specList.add(hasFirstName(filter.getLastName()));
            }
            if (StringUtils.isNotEmpty(filter.getSurname())) {
                specList.add(hasFirstName(filter.getSurname()));
            }
            if (StringUtils.isNotEmpty(filter.getPhoneNumber())) {
                specList.add(hasFirstName(filter.getPhoneNumber()));
            }
            if (StringUtils.isNotEmpty(filter.getEmail())) {
                specList.add(hasFirstName(filter.getEmail()));
            }

            return SpecificationComposer.compose(specList);
        }
    }
}
