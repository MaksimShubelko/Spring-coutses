package com.example.springcourses.entity;

import lombok.*;

import javax.persistence.Embeddable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Embeddable
public class SecureInformation {

    private String firstName;
    private String surname;
    private String lastName;
    private String email;
    private String phoneNumber;
}
