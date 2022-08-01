package com.example.springcourses.entity;

import com.example.springcourses.converter.RoleConverter;
import com.example.springcourses.converter.UserStatusConverter;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Objects;
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
    @GeneratedValue
    private UUID userId;

    private String login;

    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Embedded
    private SecureInformation secureInformation;

    @Convert(converter = UserStatusConverter.class)
    private UserStatus userStatus;

    @Convert(converter = RoleConverter.class)
    private UserRole userRole;

    @Override
    public UUID getId() {
        return userId;
    }

    @PreUpdate
    @PrePersist
    private void initializeFullName() {
        if (Objects.nonNull(secureInformation)) {
            fullName = secureInformation.getSurname()
                    + " "
                    + secureInformation.getFirstName();
        }
    }


}
