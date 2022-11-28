package com.example.springcourses.security;

import com.example.springcourses.entity.UserEntity;
import com.example.springcourses.entity.UserRole;
import com.example.springcourses.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
        User user = new User(userEntity.getLogin(),
                userEntity.getPassword(),
                userEntity.isEnabled(),
                userEntity.isAccountNonExpired(),
                userEntity.isCredentialsNonExpired(),
                userEntity.isAccountNonLocked(),
                convertToAuthorities(userEntity.getUserRole()));


        return user;
    }

    private Collection<? extends GrantedAuthority> convertToAuthorities(UserRole userRole) {
        if (userRole != null) {
            return Collections.singleton(new SimpleGrantedAuthority(userRole.name()));
        } else {
            return Collections.emptySet();
        }
    }
}
