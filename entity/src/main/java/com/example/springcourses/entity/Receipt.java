package com.example.springcourses.entity;

import java.util.UUID;

public class Receipt implements BaseEntity<UUID> {

    private UUID receiptId;
    private Student student;
    private Request request;
    private Double cost;

    @Override
    public UUID getId() {
        return receiptId;
    }
}
