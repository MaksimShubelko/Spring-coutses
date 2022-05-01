package com.example.springcourses.config;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component("mainRunner")
public class Runner implements CommandLineRunner {

    @Value("${spring.datasource.password:undefined}")
    private String dbPwd;

    @Qualifier("customEncryptor")
    @Autowired
    StringEncryptor stringEncryptor;

    @Override
    public void run(String... args) throws Exception {
        String pwd = "dev_pwd";
        String encrypt = stringEncryptor.encrypt(pwd);
        System.out.println(encrypt);
        String decrypt = stringEncryptor.decrypt(encrypt);
        System.out.println(decrypt);
        System.out.println(dbPwd);
    }
}
