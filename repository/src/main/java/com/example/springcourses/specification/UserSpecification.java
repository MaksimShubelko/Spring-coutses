package com.example.springcourses.specification;

import com.example.springcourses.entity.UserEntity;
import com.example.springcourses.entity.UserEntity_;
import com.example.springcourses.specification.filter.SpecBuilder;
import com.example.springcourses.specification.filter.UserFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public interface UserSpecification extends Specification<UserEntity> {

    static UserSpecification hasFirstName(String value) {
        return (root, cq, cb) -> cb.equal(cb.lower(root.get(UserEntity_.FIRST_NAME)), value.toLowerCase());

    }

    static UserSpecification hasLastName(String value) {
        return (root, cq, cb) -> cb.equal(cb.lower(root.get(UserEntity_.LAST_NAME)), value.toLowerCase());

    }

    static UserSpecification hasSurname(String value) {
        return (root, cq, cb) -> cb.equal(cb.lower(root.get(UserEntity_.SURNAME)), value.toLowerCase());
    }

    static UserSpecification hasPhoneNumber(String value) {
        return (root, cq, cb) -> cb.equal(cb.lower(root.get(UserEntity_.PHONE_NUMBER)), "%" + value.toLowerCase() + "%");
    }

    static UserSpecification hasEmail(String value) {
        return (root, cq, cb) -> cb.equal(cb.lower(root.get(UserEntity_.EMAIL)), value.toLowerCase());
    }

    static UserSpecification firstNameLike(String value) {
        return (root, cq, cb) -> cb.like(cb.lower(root.get(UserEntity_.FIRST_NAME)), "%" + value.toLowerCase() + "%");

    }

    static UserSpecification lastNameLike(String value) {
        return (root, cq, cb) -> cb.like(cb.lower(root.get(UserEntity_.LAST_NAME)), "%" + value.toLowerCase() + "%");

    }

    static UserSpecification surnameLike(String value) {
        return (root, cq, cb) -> cb.like(cb.lower(root.get(UserEntity_.SURNAME)), "%" + value.toLowerCase() + "%");
    }

    static UserSpecification phoneNumberLike(String value) {
        return (root, cq, cb) -> cb.like(cb.lower(root.get(UserEntity_.PHONE_NUMBER)), "%" + value.toLowerCase() + "%");
    }

    static UserSpecification emailLike(String value) {
        return (root, cq, cb) -> cb.like(cb.lower(root.get(UserEntity_.EMAIL)), "%" + value.toLowerCase() + "%");
    }

    static Specification<UserEntity> findByTerm(String term) {
        List<Specification<UserEntity>> specList = new ArrayList<>();
        specList.add(firstNameLike(term));
        specList.add(lastNameLike(term));
        specList.add(surnameLike(term));
        specList.add(phoneNumberLike(term));
        specList.add(emailLike(term));

        return SpecificationComposer.compose(specList, Predicate.BooleanOperator.OR);
    }

    static UserSpecification.Builder builder() {
        return new UserSpecification.Builder();
    }

    class Builder extends SpecBuilder<UserEntity, UserFilter> {
        @Override
        public Specification<UserEntity> build() {
            List<Specification<UserEntity>> specList = new ArrayList<>();
            if (StringUtils.isNotEmpty(filter.getTerm())) {
                specList.add(findByTerm(filter.getTerm()));
            } else {
                if (StringUtils.isNotEmpty(filter.getFirstName())) {
                    specList.add(hasFirstName(filter.getFirstName()));
                }
                if (StringUtils.isNotEmpty(filter.getLastName())) {
                    specList.add(hasLastName(filter.getLastName()));
                }
                if (StringUtils.isNotEmpty(filter.getSurname())) {
                    specList.add(hasSurname(filter.getSurname()));
                }
                if (StringUtils.isNotEmpty(filter.getPhoneNumber())) {
                    specList.add(hasPhoneNumber(filter.getPhoneNumber()));
                }
                if (StringUtils.isNotEmpty(filter.getEmail())) {
                    specList.add(hasEmail(filter.getEmail()));
                }
            }
            return SpecificationComposer.compose(specList);
        }
    }
}
