package com.example.springcourses.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
