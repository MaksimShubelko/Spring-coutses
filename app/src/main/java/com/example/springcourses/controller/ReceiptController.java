package com.example.springcourses.controller;

import com.example.springcourses.services.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ReceiptController {

    private final ReceiptService receiptService;
}
