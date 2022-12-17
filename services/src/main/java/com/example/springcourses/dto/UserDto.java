package com.example.springcourses.dto;

import com.example.springcourses.entity.UserRole;
import com.example.springcourses.entity.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class UserDto {

    private Long userId;

    @Pattern(regexp = "^[a-zA-Z0-9]{3,10}$", message = "Login may contain a-z, A-Z, 0-9, and has from 3 to 10 chars")
    private String login;

    @Pattern(regexp = "^[a-zA-Z0-9]{8,30}$", message =
            "A digit must occur at least once, " +
            "a lower case letter must occur at least once, " +
            "an upper case letter must occur at least once, " +
            "a special character must occur at least once, " +
            "no whitespace allowed in the entire string, " +
            "anything, at least eight places though ")
    private String password;

    @NotBlank(message = "This field shouldn't be empty")
    private String confirmPassword;

    private String fullName;

    @Pattern(regexp = "^.{3,20}$", message = "This field should has from 3 to 20 chars")
    private String firstName;

    @Pattern(regexp = "^.{3,20}$", message = "This field should has from 3 to 20 chars")
    private String surname;

    @Pattern(regexp = "^.{3,20}$", message = "This field should has from 3 to 20 chars")
    private String lastName;

    @Pattern(regexp = "^.{5,20}$", message = "This field should has from 5 to 20 chars")
    @Email(message = "Should has e-mail format")
    private String email;

    @Pattern(regexp = "^\\+375 \\((25|29|33|44)\\) [0-9]{3}-[0-9]{2}-[0-9]{2}$", message = "Input number in +375 (XX) XXX-XX-XX format")
    private String phoneNumber;

    @Valid
    private UserStatus userStatus;
    @Valid
    private UserRole userRole;
    @Valid
    private OffsetDateTime createdAt;
    @Valid
    private String createdBy;
    @Valid
    private OffsetDateTime lastModifiedAt;
    @Valid
    private String lastModifiedBy;
    @Valid
    private TeacherDto teacherDto;
    @Valid
    private StudentDto studentDto;


    public boolean isNew() {
        return this.userId == null;
    }
}
