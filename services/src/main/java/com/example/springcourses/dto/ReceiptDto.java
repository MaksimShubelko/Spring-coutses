package com.example.springcourses.dto;

import com.example.springcourses.entity.ReceiptStatus;
import com.example.springcourses.entity.Request;
import com.example.springcourses.entity.Student;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ReceiptDto {

    private Long receiptId;
    private String nameOfFavor;
    private OffsetDateTime dateOfPayment;
    private ReceiptStatus receiptStatus = ReceiptStatus.PENDING;
    private StudentDto studentDto;
    private RequestDto requestDto;
    private BigDecimal cost;
}
