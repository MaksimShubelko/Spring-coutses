package com.example.springcourses.services.jpa;

import com.example.springcourses.dto.*;
import com.example.springcourses.entity.Request;
import com.example.springcourses.entity.RequestStatus;
import com.example.springcourses.mapper.*;
import com.example.springcourses.repository.*;
import com.example.springcourses.services.RequestService;
import com.example.springcourses.services.config.JpaImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@JpaImplementation
public class RequestJpaService extends AbstractJpaService<RequestDto, Request, Long> implements RequestService {

    private final RequestRepository repository;
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
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
        String login = principal.getName();
        StudentDto studentDto = studentMapper
                .mapToDto(studentRepository.findStudentByLogin(login).orElseThrow());
        CourseDto courseDto = courseMapper
                .mapToDto(courseRepository.findById(courseId).orElseThrow());
        RequestDto dto = mapper.mapToDto(repository.findByStudent(studentMapper.map(studentDto))
                        .orElse(Request.builder().student(studentMapper
                                        .map(studentDto)).build()));

        dto.setCourseDto(courseDto);
        dto.setStudentDto(studentDto);
        repository.save(mapToEntity(dto));

    }

    @Override
    public List<RequestDto> findNewByCourse(CourseDto courseDto) {
        return repository
                .findAllByCourseWithRequestStatusNew(courseMapper.map(courseDto))
                        .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addStudentToGroup(GroupDto groupDto, Long requestId) {
        RequestDto requestDto = mapToDto(repository.findById(requestId).orElseThrow());
        StudentDto studentDto = requestDto.getStudentDto();
        studentDto.setGroupDto(groupDto);
        studentRepository.save(studentMapper.map(studentDto));
        requestDto.setRequestStatus(RequestStatus.APPROVING);
        repository.save(mapper.map(requestDto));

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

