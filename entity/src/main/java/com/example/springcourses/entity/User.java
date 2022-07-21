package com.example.springcourses.entity;

import com.example.springcourses.converter.RoleConverter;
import com.example.springcourses.converter.UserStatusConverter;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
@Entity
public abstract class User extends BaseEntity<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID userId;

    private String firstName;

    private String surname;

    private String lastName;

    private String login;

    private String password;

    private String email;

    private String phoneNumber;

    @Convert(converter = UserStatusConverter.class)
    private UserStatus userStatus;

    @Convert(converter = RoleConverter.class)
    private UserRole userRole;

    @Override
    public UUID getId() {
        return userId;
    }
}
