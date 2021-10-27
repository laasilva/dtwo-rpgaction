package com.dtwo.rpgaction.mapper;

import com.dtwo.rpgaction.model.entities.User;
import com.dtwo.rpgaction.model.request.UserRequest;
import com.dtwo.rpgaction.utils.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class UserMapperImpl implements UserMapper {

    private PasswordEncoder passwordEncoder;

    public UserMapperImpl() {
        this.passwordEncoder = new PasswordEncoder();
    }

    @Override
    public User userRequestToEntity(UserRequest userRequest) {
        User userEntity = new User();

        userEntity.setUsername(userRequest.getUsername());
        userEntity.setPassword(passwordEncoder.encodePassword(userRequest.getPassword()));
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setRegistrationDate(new Date());

        System.out.println("/n/n ***"  + userEntity.getPassword() + "/n/n");

        return userEntity;
    }
}
