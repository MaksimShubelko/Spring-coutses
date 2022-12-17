package com.example.springcourses.services.jpa;

import com.example.springcourses.dto.CourseDto;
import com.example.springcourses.dto.StudentDto;
import com.example.springcourses.entity.Student;
import com.example.springcourses.mapper.CourseMapper;
import com.example.springcourses.mapper.StudentMapper;
import com.example.springcourses.repository.CourseRepository;
import com.example.springcourses.repository.StudentRepository;
import com.example.springcourses.services.StudentService;
import com.example.springcourses.services.config.JpaImplementation;
import com.example.springcourses.specification.SearchableRepository;
import com.example.springcourses.specification.SearchableService;
import com.example.springcourses.specification.filter.StudentFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ComponentScan(basePackages = "com.example.springcourses.mapper")
@RequiredArgsConstructor
@JpaImplementation
public class StudentJpaService extends AbstractJpaService<StudentDto, Student, Long> implements StudentService, SearchableService<Student> {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public JpaRepository<Student, Long> getRepository() {
        return studentRepository;
    }

    @Override
    public StudentDto findById(Long aLong) {
        return mapToDto(studentRepository.getById(aLong));
    }

    @Override
    public SearchableRepository<Student, ?> getSearchRepository() {
        return studentRepository;
    }

    @Override
    public List<StudentDto> findStudent(StudentDto studentDto) {
        ExampleMatcher caseInsensitiveExMatcher = ExampleMatcher
                .matchingAll().withIgnoreCase();
        Example<Student> studentExample = Example
                .of(studentMapper.map(studentDto), caseInsensitiveExMatcher);

        return studentRepository
                .findAll(studentExample)
                .stream()
                .map(studentMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto findStudentByLogin(String login) {
        return studentMapper.mapToDto(studentRepository.findStudentByLogin(login).orElse(null));
    }

    @Override
    public List<StudentDto> findStudentsToApproving(CourseDto courseDto) {
        return studentRepository.findByRequestNewAndCourse(courseMapper.map(courseDto))
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Page<StudentDto> search(StudentFilter studentFilter) {

        return searchPage(studentFilter).map(studentMapper::mapToDto);
    }

    @Override
    public StudentDto mapToDto(Student entity) {
        return studentMapper.mapToDto(entity);
    }

    @Override
    public Student mapToEntity(StudentDto dto) {
        return studentMapper.map(dto);
    }
}
