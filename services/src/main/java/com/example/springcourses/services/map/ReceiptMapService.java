package com.example.springcourses.services.map;

import com.example.springcourses.entity.Receipt;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ReceiptMapService extends AbstractMapService<Receipt, UUID> {

    private static final Map<UUID, Receipt> resource = new HashMap<>();

    @Override
    public Map<UUID, Receipt> getResource() {
        return resource;
    }
}
