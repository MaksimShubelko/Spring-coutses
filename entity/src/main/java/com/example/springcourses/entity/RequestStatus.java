package com.example.springcourses.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RequestStatus {
    NEW("New"),
    UNDER_CONSIDERATION("Under consideration"),
    REVIEWED("Reviewed");

    String status;

}
