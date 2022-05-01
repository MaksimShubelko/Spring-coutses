package com.example.springcourses.config;

import com.ulisesbocchio.jasyptspringboot.encryptor.*;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PBEByteEncryptor;
import org.jasypt.salt.SaltGenerator;
import org.jasypt.salt.StringFixedSaltGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncryptConfig {

    @Value("${jasypt.encryptor.password:}")
    private String password;

    @Value("${jasypt.encryptor.algorithm:PBEWithHmacSHA512AndAES_128}")
    private String algorithm;

    @Value("${jasypt.encryptor.key-obtention-iterations:1}")
    private int iterations;

    @Value("${jasypt.encryptor.salt:salt}")
    private String salt;

    @Bean("customEncryptor")
    public StringEncryptor stringEncryptor(PBEByteEncryptor delegate) {
        return new SimplePBEStringEncryptor(delegate);
    }

    @Bean
    public PBEByteEncryptor pbeByteEncryptor(SaltGenerator saltGenerator) {
        SimplePBEByteEncryptor encryptor = new SimplePBEByteEncryptor();
        encryptor.setPassword(password);
        encryptor.setAlgorithm(algorithm);
        encryptor.setIterations(iterations);
        encryptor.setSaltGenerator(saltGenerator);
        return encryptor;
    }

    @Bean
    public SaltGenerator saltGenerator() {
        return new StringFixedSaltGenerator(salt);
    }

}
