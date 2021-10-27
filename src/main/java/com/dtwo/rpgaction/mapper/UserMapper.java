package com.dtwo.rpgaction.mapper;

import com.dtwo.rpgaction.model.entities.User;
import com.dtwo.rpgaction.model.request.UserRequest;

public interface UserMapper {
    User userRequestToEntity(UserRequest userRequest);
}
