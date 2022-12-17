package com.example.springcourses.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum RequestStatus {
    NEW("New"),
    UNDER_CONSIDERATION("Under consideration"),
    APPROVING("Approving");

    private final String status;

    private static final Map<String, RequestStatus> MAP = Arrays.stream(RequestStatus.values())
            .collect(Collectors.toMap(RequestStatus::getStatus, Function.identity()));

    public static RequestStatus getByValue(String value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException();
        }

        RequestStatus requestStatus = MAP.get(value);
        return Objects.isNull(requestStatus) ? UNDER_CONSIDERATION : requestStatus;
    }

}
