//package com.example.springcourses.api;
//
//import com.example.springcourses.dto.StudentDto;
//import com.example.springcourses.dto.TeacherDto;
//import com.example.springcourses.dto.UserDto;
//import com.example.springcourses.entity.Student;
//import com.example.springcourses.mapper.TeacherMapper;
//import com.example.springcourses.repository.StudentReceiptRepository;
//import com.example.springcourses.repository.StudentRepository;
//import com.example.springcourses.repository.TeacherRepository;
//import com.example.springcourses.services.StudentService;
//import com.example.springcourses.specification.filter.StudentFilter;
//import com.example.system.repository.SystemRepository;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//
//@RequiredArgsConstructor
//@RequestMapping("/")
//@RestController
//public class TestingController {
//
//    /*private final TeacherRepository teacherRepository;
//    private final TeacherMapper teacherMapper;
//    private final StudentRepository studentRepository;
//    private final StudentReceiptRepository studentReceiptRepository;
//    private final SystemRepository systemRepository;
//    private final StudentService studentService;*/
//
//    /*@ApiOperation(value = "Get all students", response = Student.class, responseContainer = "List")
//    @GetMapping("/students/all")
//    public List<Student> getStudents() {
//        return studentRepository.findAll();
//    }
//
//    @ApiOperation(value = "Find students", response = Student.class, responseContainer = "List")
//    @PutMapping("/students/find")
//    public List<StudentDto> findStudents(@ApiParam(value = "Search example") @RequestBody StudentDto studentDto) {
//        return studentService.findStudent(studentDto);
//    }
//
//    @ApiOperation(value = "Search students", response = Student.class, responseContainer = "Page")
//    @PutMapping("/students/search")
//    public Page<StudentDto> search(@RequestParam(required = false) String term,
//                                   @RequestParam(required = false) Integer pageNumber) {
//        StudentFilter studentFilter = StudentFilter.builder()
//                .pageNumber(pageNumber)
//                .term(term)
//                .build();
//        System.out.println(studentService);
//        return studentService.search(studentFilter);
//    }*/
//
//
//
//}
