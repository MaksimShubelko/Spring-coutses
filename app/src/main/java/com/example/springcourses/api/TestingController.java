package com.example.springcourses.api;

import com.example.springcourses.entity.StudentReceipt;
import com.example.springcourses.repository.StudentReceiptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/")
@RestController
public class TestingController {

    private final StudentReceiptRepository studentReceiptRepository;

    @GetMapping("/view")
    public List<StudentReceipt> getView() {
        return studentReceiptRepository.findByPayerContainsIgnoreCase("");

    }
}
