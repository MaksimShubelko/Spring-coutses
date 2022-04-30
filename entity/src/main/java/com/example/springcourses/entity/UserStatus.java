package com.example.springcourses.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public enum UserStatus {
    BLOCKED("Blocked"),
    DELETED("Deleted");

    private final String value;
}
