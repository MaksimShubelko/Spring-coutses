/*
package com.example.springcourses.services.impl;

import com.example.springcourses.dto.UserDetailsDto;
import com.example.springcourses.dto.UserDto;
import com.example.springcourses.entity.User;
import com.example.springcourses.mapper.UserMapper;
import com.example.springcourses.repository.StudentRepository;
import com.example.springcourses.repository.TeacherRepository;
import com.example.springcourses.repository.UserRepository;
import com.example.springcourses.services.UserService;
import com.example.springcourses.services.jpa.AbstractJpaService;
import com.example.springcourses.specification.SearchableRepository;
import com.example.springcourses.specification.SearchableService;
import com.example.springcourses.specification.filter.UserFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl extends AbstractJpaService<UserDto, User, Long> implements UserService, SearchableService<User> {

    private final UserRepository repository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final UserMapper mapper;

    @Override
    public JpaRepository<User, Long> getRepository() {
        return repository;
    }

    @Override
    public User mapToEntity(UserDto dto) {
        System.out.println(mapper.mapDtoToEntity(dto).getLastModifiedAt());
        return mapper.mapDtoToEntity(dto);
    }

    @Override
    public UserDto mapToDto(User entity) {
        return mapper.mapToDto(entity);
    }

    @Override
    public Page<UserDto> search(UserFilter filter) {
        return searchPage(filter).map(this::mapToDto);
    }

    @Override
    public List<UserDto> findUser(UserDto dto) {
        ExampleMatcher caseInsensitiveExMatcher = ExampleMatcher.matchingAll().withIgnoreCase();
        Example<User> userExample = Example.of(mapper.mapDtoToEntity(dto), caseInsensitiveExMatcher);

        return repository.findAll(userExample).stream().map(mapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void create(UserDto userDto) {
        repository.save(mapper.mapDtoToEntity(userDto));
    }

    @Override
    public void update(Long id, UserDto userDto) {
        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isPresent()) {
            User user;
            user = mapper.mapDtoToEntity(userDto);
            repository.save(user);
        }
    }

    @Override
    public UserDto findById(Long aLong) {
        return repository
                .findById(aLong)
                .map(mapper::mapToDto)
                .orElseThrow(() -> new NoSuchElementException("not found"));
    }

    @Override
    public Collection<UserDto> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDetailsDto findUserDetailsById(Long id) {
        Optional<User> user = repository.findById(id);
        UserDetailsDto userDetailsDto = null;
        if (user.isPresent()) {
            System.out.println("USERRRRR " + user.get());
            userDetailsDto = mapper.mapToDetails(user.get());
        }
        return userDetailsDto;
    }

    @Override
    public void delete(Long userId) {
        repository.deleteById(userId);
    }

    @Override
    public SearchableRepository<User, ?> getSearchRepository() {
        return repository;
    }
}
*/
