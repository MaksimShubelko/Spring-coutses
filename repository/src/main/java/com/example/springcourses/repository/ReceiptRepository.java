package com.example.springcourses.repository;

import com.example.springcourses.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    
    @Transactional
    @Modifying
    @Query("DELETE FROM Receipt r where r.receiptStatus = com.example.springcourses.entity.ReceiptStatus.CANCELLED")
    void deleteCancelled();
}
