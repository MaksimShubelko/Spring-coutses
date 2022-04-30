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
public class User implements BaseEntity<UUID> {

    private UUID userId;
    private String firstName;
    private String surname;
    private String lastName;
    private Student student;
    private Teacher teacher;
    private UserStatus userStatus;

    @Override
    public UUID getId() {
        return userId;
    }
}
