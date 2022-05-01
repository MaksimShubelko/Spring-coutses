package com.example.springcourses.services.map;

import com.example.springcourses.entity.Receipt;
import com.example.springcourses.services.ReceiptService;
import com.example.springcourses.services.config.MapImplementation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@MapImplementation
public class ReceiptMapService extends AbstractMapService<Receipt, UUID> implements ReceiptService {

    private static final Map<UUID, Receipt> resource = new HashMap<>();

    @Override
    public Map<UUID, Receipt> getResource() {
        return resource;
    }
}
