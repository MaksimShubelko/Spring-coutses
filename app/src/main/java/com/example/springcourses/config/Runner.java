package com.example.springcourses.config;

import com.example.springcourses.repository.*;
import lombok.RequiredArgsConstructor;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan(basePackages = "com.example.springcourses.repository.*")
@RequiredArgsConstructor
@Component("mainRunner")
public class Runner implements CommandLineRunner {

    @Value("${spring.datasource.password:undefined}")
    private String dbPwd;

    @Qualifier("customEncryptor")
    @Autowired
    StringEncryptor stringEncryptor;

    private final AcademicPerformanceRepository academicPerformanceRepository;
    private final AnswerRepository answerRepository;
    private final CorrectAnswerRepository correctAnswerRepository;
    private final CourseRepository courseRepository;
    private final GroupRepository groupRepository;
    private final LessonRepository lessonRepository;
    private final QuestionRepository questionRepository;
    private final ReceiptRepository receiptRepository;
    private final RequestRepository repository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final TestRepository testRepository;
    private final ThemeRepository themeRepository;
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        /*encrypt();*/
        /*Course course = Course.builder()
                .courseName("first")
                .build();
        Theme theme = Theme.builder()
                .course(course)
                .build();
        course.setThemes(List.of(theme));
        *//*courseRepository.save(course);*//*
        themeRepository.save(theme);*/

    }

    private void encrypt() {
        String pwd = "prod_pwd";
        String encrypt = stringEncryptor.encrypt(pwd);
        System.out.println(encrypt);
        String decrypt = stringEncryptor.decrypt("WzBZMDgGCSqGSIb3DQEFDDArBBRioHdVuLmba8DF21TCmpt2zsJ42gICEAACARAwDAYIKoZIhvcNAgsFADAdBglghkgBZQMEAQIEEPhWfI9R7JSvMSnWlVidpMGzEK6nN7gMYC6WtJb8lI5G");
        System.out.println(decrypt);
        System.out.println(dbPwd);
    }
}
