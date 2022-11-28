package com.example.springcourses.services.jpa;

import com.example.springcourses.dto.CourseDto;
import com.example.springcourses.dto.RequestDto;
import com.example.springcourses.dto.StudentDto;
import com.example.springcourses.dto.UserDto;
import com.example.springcourses.entity.Course;
import com.example.springcourses.entity.Request;
import com.example.springcourses.mapper.CourseMapper;
import com.example.springcourses.mapper.RequestMapper;
import com.example.springcourses.mapper.StudentMapper;
import com.example.springcourses.repository.CourseRepository;
import com.example.springcourses.repository.RequestRepository;
import com.example.springcourses.repository.StudentRepository;
import com.example.springcourses.repository.UserRepository;
import com.example.springcourses.services.RequestService;
import com.example.springcourses.services.config.JpaImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.Principal;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@JpaImplementation
public class RequestJpaService extends AbstractJpaService<RequestDto, Request, Long> implements RequestService {

    private final RequestRepository repository;
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final UserRepository userRepository;
    private final RequestMapper mapper;

    @Override
    public RequestDto findById(Long aLong) {

        return repository
                .findById(aLong)
                .map(mapper::mapToDto)
                .orElseThrow();
    }

    @Override
    public void save(RequestDto dto) {
        repository.save(mapper.map(dto));
    }

    @Override
    public Collection<RequestDto> findAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addRequest(Long courseId, Principal principal) {
        // TODO
        String login = principal.getName();
        StudentDto studentDto = studentMapper.mapToDto(studentRepository.findStudentByLogin(login).orElseThrow());
        CourseDto courseDto = courseMapper.mapToDto(courseRepository.findById(courseId).orElseThrow());
        RequestDto dto = mapper.mapToDto(repository.findByStudent(studentMapper.map(studentDto)).orElse(Request.builder().student(studentMapper.map(studentDto)).build()));
        dto.setCourseDto(courseDto);
        dto.setStudentDto(studentDto);
        repository.save(mapToEntity(dto));

    }

    @Override
    public void delete(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public RequestDto mapToDto(Request entity) {
        return mapper.mapToDto(entity);
    }

    @Override
    public Request mapToEntity(RequestDto dto) {
        return mapper.map(dto);
    }

    @Override
    public JpaRepository<Request, Long> getRepository() {
        return repository;
    }
}

