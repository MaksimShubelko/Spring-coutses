package com.example.springcourses.api;

import com.example.springcourses.services.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/receipts")
@RestController
public class ReceiptRestController {

    private final ReceiptService receiptService;

    @PutMapping("/{id}/cancel")
    public void cancelReceipt(@PathVariable Long id) {
        receiptService.cancelReceipt(id);
    }

    @PutMapping("/{id}/payed")
    public void markReceiptAsPayed(@PathVariable Long id) {
        receiptService.markReceiptAsPayed(id);
    }

}
