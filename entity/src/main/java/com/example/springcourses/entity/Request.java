package com.example.springcourses.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Request implements BaseEntity<Long> {
    private Long requestId;
    private RequestStatus requestStatus;

    @Override
    public Long getId() {
        return requestId;
    }
}
