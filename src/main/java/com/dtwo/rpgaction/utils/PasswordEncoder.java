package com.dtwo.rpgaction.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private PasswordEncoder(){}

    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public Boolean isPasswordValid(String encodedPassword, String password) {
        return passwordEncoder.matches(password, encodedPassword);
    }
}
