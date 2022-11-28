package com.example.springcourses.services.map;

import com.example.springcourses.dto.ReceiptDto;
import com.example.springcourses.entity.Receipt;
import com.example.springcourses.services.ReceiptService;
import com.example.springcourses.services.config.MapImplementation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@MapImplementation
public class ReceiptMapService extends AbstractMapService<ReceiptDto, Long> implements ReceiptService {

    private static final Map<Long, ReceiptDto> resource = new HashMap<>();

    @Override
    public Map<Long, ReceiptDto> getResource() {
        return resource;
    }

    @Override
    public void cancelReceipt(Long id) {

    }

    @Override
    public void markReceiptAsPayed(Long id) {

    }
}
