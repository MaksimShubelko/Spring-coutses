package com.example.springcourses.services;

import com.example.springcourses.dto.ReceiptDto;
import com.example.springcourses.entity.CorrectAnswer;
import com.example.springcourses.entity.Receipt;

import java.util.UUID;

public interface ReceiptService extends CrudService<ReceiptDto, Long> {
    void cancelReceipt(Long id);

    void markReceiptAsPayed(Long id);
}
