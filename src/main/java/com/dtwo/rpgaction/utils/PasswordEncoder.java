package com.dtwo.rpgaction.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public PasswordEncoder() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public Boolean isPasswordValid(String encodedPassword, String password) {
        return passwordEncoder.matches(password, encodedPassword);
    }
}
