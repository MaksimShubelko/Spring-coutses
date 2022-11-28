package com.example.springcourses.entity;

import com.example.springcourses.annotation.View;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Entity
@View
@Table(name = "student_receipt")
public class StudentReceipt {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "receipt_id")
    private Long receiptId;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "payer")
    private String payer;

    @Column(name = "payer_phone")
    private String payerPhone;

    @Column(name = "date_of_payment")
    private OffsetDateTime dateOfPayment;

    @Column(name = "status")
    private String status;
}
