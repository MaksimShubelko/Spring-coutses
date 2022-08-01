package com.example.springcourses.repository;

import com.example.springcourses.entity.StudentReceipt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentReceiptRepository extends JpaRepository<StudentReceipt, Long> {
    List<StudentReceipt> findByPayerContainsIgnoreCase(String payer);
}
