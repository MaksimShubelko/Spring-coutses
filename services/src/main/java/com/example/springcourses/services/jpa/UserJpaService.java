package com.example.springcourses.services.jpa;

import com.example.springcourses.dto.StudentDto;
import com.example.springcourses.dto.TeacherDto;
import com.example.springcourses.dto.UserDetailsDto;
import com.example.springcourses.dto.UserDto;
import com.example.springcourses.entity.LoginSuccess;
import com.example.springcourses.entity.UserEntity;
import com.example.springcourses.entity.UserStatus;
import com.example.springcourses.mapper.StudentMapper;
import com.example.springcourses.mapper.TeacherMapper;
import com.example.springcourses.mapper.UserMapper;
import com.example.springcourses.repository.LoginSuccessRepository;
import com.example.springcourses.repository.StudentRepository;
import com.example.springcourses.repository.TeacherRepository;
import com.example.springcourses.repository.UserRepository;
import com.example.springcourses.services.UserService;
import com.example.springcourses.services.config.JpaImplementation;
import com.example.springcourses.specification.SearchableRepository;
import com.example.springcourses.specification.SearchableService;
import com.example.springcourses.specification.filter.UserFilter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@JpaImplementation
public class UserJpaService extends AbstractJpaService<UserDto, UserEntity, Long> implements UserService, SearchableService<UserEntity> {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final LoginSuccessRepository loginSuccessRepository;


    @Override
    public JpaRepository<UserEntity, Long> getRepository() {
        return repository;
    }

    @Override
    public UserEntity mapToEntity(UserDto dto) {
        /*UserEntity userEntity = dto.getUserId() == null ? getNewUser() : repository
                .findById(dto.getUserId()).orElseThrow();
        mapper.map(dto, userEntity);*/ //TODO
        return mapper.mapDtoToEntity(dto);
    }

    private UserEntity getNewUser() {
        return new UserEntity();
    }

    @Override
    public UserDto mapToDto(UserEntity entity) {
        return mapper.mapToDto(entity);
    }

    @Override
    public Page<UserDto> search(UserFilter filter) {
        return searchPage(filter).map(this::mapToDto);
    }

    @Override
    public List<UserDto> findUser(UserDto dto) {
        ExampleMatcher caseInsensitiveExMatcher = ExampleMatcher.matchingAll().withIgnoreCase();
        Example<UserEntity> userExample = Example.of(mapper.mapDtoToEntity(dto), caseInsensitiveExMatcher);

        return repository.findAll(userExample).stream().map(mapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void create(UserDto userDto) {
        repository.save(mapper.mapDtoToEntity(userDto));
    }

    @Override
    public void update(Long id, UserDto userDto) {
        Optional<UserEntity> userOptional = repository.findById(id);
        if (userOptional.isPresent()) {
            UserEntity userEntity;
            userEntity = mapper.mapDtoToEntity(userDto);
            repository.save(userEntity);
        }
    }

    @Override
    public void saveAndLink(UserDto userDto) {
        TeacherDto teacherDto = userDto.getTeacherDto();
        save(userDto);

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
        Optional<UserEntity> user = repository.findById(id);
        UserDetailsDto userDetailsDto = null;
        if (user.isPresent()) {
            userDetailsDto = mapper.mapToDetails(user.get());
        }
        return userDetailsDto;
    }


    @Override
    public void save(UserDto dto) {
        repository.save(mapToEntity(dto));

    }

    @Override
    public void addStudent(UserDto userDto) {
        userDto.setStudentDto(StudentDto.builder().build());
        this.save(userDto);
    }

    @Override
    public void blockUnusedUsers() {
        repository.findAll()
                .forEach(
                user -> {
                    Optional<LoginSuccess> loginSuccess = loginSuccessRepository
                            .findTopByUserOrderByLastModifiedDateDesc(user);
                    if (loginSuccess.isPresent()) {
                        OffsetDateTime lastLogin = loginSuccess.get().getLastModifiedDate();
                        if (lastLogin.isBefore(OffsetDateTime.now().minusDays(365))) {
                            user.setUserStatus(UserStatus.BLOCKED);
                            repository.save(user);
                        }
                    }
                }
        );
    }

    @Override
    public boolean existsByLogin(String login) {
        return repository.existsByLogin(login);
    }

    @Override
    public boolean isTeacherExists(UserDetailsDto dto) {
        return Objects.nonNull(repository
                .findByTeacher(mapper.mapDetailsToUser(dto))); //TODO without getter
    }

    @Override
    public boolean isStudentExists(UserDetailsDto dto) {
        return Objects.nonNull(repository
                .findByStudent(mapper.mapDetailsToUser(dto))); //TODO without getter
    }

    @Override
    public void delete(Long userId) {
        repository.deleteById(userId);
    }

    @Override
    public SearchableRepository<UserEntity, ?> getSearchRepository() {
        return repository;
    }


}
