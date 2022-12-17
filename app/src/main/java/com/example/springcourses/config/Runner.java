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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*@ComponentScan(basePackages = "com.example.springcourses.repository.*")
@RequiredArgsConstructor
@Component("mainRunner")*//*

public class Runner implements CommandLineRunner {

    */
/*@Value("${spring.datasource.password:undefined}")
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

        for (int i = 0; i < 5; i++) {

            List<Integer> a = createIntegerList();
            List<Integer> b = createIntegerList();
            merge(a, b);

        }

    }


    public static void merge(List<Integer> a, List<Integer> b) {
        List<Integer> newArray = new ArrayList<>(a.size());
        newArray.addAll(a);
        int resultSize = a.size() + b.size();
        a.clear();

        int indexA = 0;
        int indexB = 0;
        for (int i = 0; i < resultSize; i++) {
            if (indexA >= newArray.size()) {
                a.add(b.get(indexB++));
            } else if (indexB >= b.size()) {
                a.add(newArray.get(indexA++));
            } else if (newArray.get(indexA) <= b.get(indexB)) {
                a.add(newArray.get(indexA++));
            } else {
                a.add(b.get(indexB++));
            }
        }
    }

    private static List<Integer> createIntegerList() {
        List<Integer> result = new ArrayList<>();
        Random random = new Random();
        int minSize = 100;
        int value = 0;
        for (int i = 0; i < Math.max(minSize, random.nextInt(10000)); i++) {
            value += random.nextInt(10);
            result.add(value);
        }
        return result;
    }

    private void encrypt() {
        String pwd = "system_pwd";
        String encrypt = stringEncryptor.encrypt(pwd);
        System.out.println(encrypt);
        String decrypt = stringEncryptor.decrypt("WzBZMDgGCSqGSIb3DQEFDDArBBTphCyzskmvjhssjvWZnk6/v1viRQICEAACARAwDAYIKoZIhvcNAgsFADAdBglghkgBZQMEAQIEEKRTSA/GE4PWkpCSm0o4VGpk1OywP6eEJ+GFEM0vNL1/");
        System.out.println(decrypt);
        System.out.println(dbPwd);
    }*//*

}
*/
