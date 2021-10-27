package com.dtwo.rpgaction.model.enums;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Optional;

public enum Role {
    GOD(Long.valueOf(1), "ADMIN"),
    DEV(Long.valueOf(2), "ADMIN"),
    USER(Long.valueOf(3), "USER");

    private Long id;
    private String description;

    Role(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Role getRoleByIdOrDescription(Object filter) {
        if(filter instanceof String) {
            Optional<Role> findAny = Arrays.asList(Role.values()).stream().filter(role -> role.getDescription().equals((String) filter)).findAny();
            if(findAny.isPresent()) return findAny.get();
        }

        if(filter instanceof Long) {
            Optional<Role> findAny = Arrays.asList(Role.values()).stream().filter(role -> role.getId().equals((Long) filter)).findAny();
            if(findAny.isPresent()) return findAny.get();
        }

        return null;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

}
