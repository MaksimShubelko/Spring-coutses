package com.example.springcourses.entity;

import com.example.springcourses.converter.RoleConverter;
import com.example.springcourses.converter.UserStatusConverter;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Entity
public class UserEntity extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Convert(converter = UserStatusConverter.class)
    @Column(name = "user_status")
    private UserStatus userStatus;

    @Convert(converter = RoleConverter.class)
    @Column(name = "user_role")
    private UserRole userRole;

    @ManyToMany
    @Column(name = "permission")
    private List<Permission> permissions;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    @Override
    public Long getId() {
        return userId;
    }

    @PreUpdate
    @PrePersist
    private void initializeFullName() {
        if (Objects.nonNull(surname)
                && Objects.nonNull(firstName)
                && Objects.nonNull(lastName)) {
            fullName = surname
                    + " "
                    + firstName
                    + " "
                    + lastName;
        }
    }

    @Builder.Default
    @Transient
    private boolean accountNonExpired = true;

    @Builder.Default
    @Transient
    private boolean accountNonLocked = true;

    @Builder.Default
    @Transient
    private boolean credentialsNonExpired = true;

    @Builder.Default
    @Transient
    private boolean enabled = true;

}
