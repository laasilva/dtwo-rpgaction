package com.dtwo.rpgaction.mapper;

import com.dtwo.rpgaction.model.entities.User;
import com.dtwo.rpgaction.model.request.UserRequest;

import java.util.Date;

public class UserMapperImpl implements UserMapper {

    @Override
    public User userRequestToEntity(UserRequest userRequest) {
        User userEntity = new User();

        userEntity.setUsername(userRequest.getUsername());
        userEntity.setPassword(userRequest.getPassword());
        userEntity.setRegistrationDate(new Date());

        return userEntity;
    }
}
