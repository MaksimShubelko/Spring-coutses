package com.example.springcourses.security;

import org.springframework.security.authentication.AnonymousAuthenticationProvider;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

public class RunAs {

    public static void runAsSystem(final Runnable runnable) {
        final Authentication originAuth = SecurityContextHolder.getContext().getAuthentication();

        try {
            AnonymousAuthenticationToken token = new AnonymousAuthenticationToken("system", "system",
                    Collections.singleton(new SimpleGrantedAuthority("TEACHER")));

            SecurityContextHolder.getContext().setAuthentication(token);
            runnable.run();
        } finally {
            SecurityContextHolder.getContext().setAuthentication(originAuth);
        }
    }
}
