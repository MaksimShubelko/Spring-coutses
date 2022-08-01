package com.example.springcourses.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Entity
@Table(name = "student_receipt")
public class StudentReceipt {

    @Id
    private Long receiptId;

    private BigDecimal totalAmount;

    private String payer;

    private String payerPhone;

    private OffsetDateTime dateOfPayment;

    private String status;
}
