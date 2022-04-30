package com.example.springcourses.entity;

public class Request implements BaseEntity<Long> {
    private Long requestId;
    private RequestStatus requestStatus;

    @Override
    public Long getId() {
        return requestId;
    }
}
