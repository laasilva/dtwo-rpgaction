package com.dtwo.rpgaction.mapper;

import com.dtwo.rpgaction.model.entities.User;
import com.dtwo.rpgaction.model.request.UserRequest;
import com.dtwo.rpgaction.model.response.UserResponse;

import java.util.List;

public interface UserMapper {
    User userRequestToEntity(UserRequest userRequest);
    User userRequestToUpdateEntity(User user, UserRequest userRequest);
    List<UserResponse> entityListToResponseList(List<User> users);
}
