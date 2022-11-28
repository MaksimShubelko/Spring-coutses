package com.example.springcourses.controller;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordEncodingTest {

    public static final String PASSWORD = "password";

    @Test
    void testBCryptEnc() {
        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(5);

        //System.out.println("bcrypt= " + bCryptPasswordEncoder.encode(PASSWORD));
        //System.out.println("bcrypt= " + bCryptPasswordEncoder.encode(PASSWORD));

        System.out.println("bcrypt= " + bCryptPasswordEncoder.encode("1111"));
        //System.out.println("bcrypt= " + bCryptPasswordEncoder.encode("2222"));


        //String encodedPwd = bCryptPasswordEncoder.encode(PASSWORD);
        //assertTrue(bCryptPasswordEncoder.matches(PASSWORD, encodedPwd));
    }

    @Test
    void testStandartPasswordEnc() {
        PasswordEncoder sha256 = new StandardPasswordEncoder();

        /*System.out.println("sha256= " + sha256.encode(PASSWORD));
        System.out.println("sha256= " + sha256.encode(PASSWORD));

        System.out.println("sha256= " + sha256.encode("1111"));
        System.out.println("sha256= " + sha256.encode("2222"));*/

        String encodedPwd = sha256.encode(PASSWORD);
        assertTrue(sha256.matches(PASSWORD, encodedPwd));
    }

    @Test
    void testLdap() {
        PasswordEncoder ldap = new LdapShaPasswordEncoder();

        /*System.out.println("ldap= " + ldap.encode(PASSWORD));
        System.out.println("ldap= " + ldap.encode(PASSWORD));*/

        String encodedPwd = ldap.encode(PASSWORD);
        assertTrue(ldap.matches(PASSWORD, encodedPwd));
    }

    @Test
    void testNoOp() {
        PasswordEncoder noOp = NoOpPasswordEncoder.getInstance();

        //System.out.println("noop= " + noOp.encode(PASSWORD));
    }
}
