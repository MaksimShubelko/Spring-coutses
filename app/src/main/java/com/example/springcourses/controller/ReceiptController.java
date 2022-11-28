package com.example.springcourses.controller;

import com.example.springcourses.services.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class ReceiptController {

    private final ReceiptService receiptService;

    @GetMapping("/receipts")
    public String getReceipts() {
        return "receipts/index";
    }
}
