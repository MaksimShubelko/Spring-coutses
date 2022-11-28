package com.example.springcourses.services;

import com.example.springcourses.dto.UserDetailsDto;
import com.example.springcourses.dto.UserDto;
import com.example.springcourses.specification.filter.UserFilter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserService extends CrudService<UserDto, Long> {

    default Page<UserDto> search(UserFilter filter) {
        throw new UnsupportedOperationException();
    }

    default List<UserDto> findUser(UserDto dto) {
        throw new UnsupportedOperationException();
    }

    default void create(UserDto userDto) {
        throw new UnsupportedOperationException();
    }

    default void update(Long id, UserDto userDto) {
        throw new UnsupportedOperationException();
    }

    default void delete(Long userId) {
        throw new UnsupportedOperationException();
    }

    default UserDetailsDto findUserDetailsById(Long id) {
        throw new UnsupportedOperationException();
    }

    default boolean isTeacherExists(UserDetailsDto dto) {
        throw new UnsupportedOperationException();
    }

    default boolean isStudentExists(UserDetailsDto dto) {
        throw new UnsupportedOperationException();
    }

    default void saveAndLink(UserDto userDto) {
        throw new UnsupportedOperationException();
    }

    default boolean existsByLogin(String login) {
        throw new UnsupportedOperationException();
    }

    default void registerNewAccount(UserDto userDto) {
        throw new UnsupportedOperationException();
    }

    default void blockUnusedUsers() {
        throw new UnsupportedOperationException();
    }

    default void addStudent(UserDto userDto) {
        throw new UnsupportedOperationException();
    }
}
