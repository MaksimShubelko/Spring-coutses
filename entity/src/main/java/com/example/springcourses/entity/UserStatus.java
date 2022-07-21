package com.example.springcourses.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum UserStatus {
    ACTIVE("Active"),
    UNKNOWN("Unknown"),
    BLOCKED("Blocked"),
    DELETED("Deleted");

    private final String value;

    private static final Map<String, UserStatus> MAP = Arrays.stream(UserStatus.values())
            .collect(Collectors.toMap(UserStatus::getValue, Function.identity()));

    public static UserStatus getByValue(String value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException();
        }

        UserStatus status = MAP.get(value);
        return Objects.isNull(status) ? UNKNOWN : status;
    }
}
