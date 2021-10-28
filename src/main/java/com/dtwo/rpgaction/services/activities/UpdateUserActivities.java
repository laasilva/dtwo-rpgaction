package com.dtwo.rpgaction.services.activities;

import com.dtwo.rpgaction.exception.ActionException;
import com.dtwo.rpgaction.mapper.UserMapper;
import com.dtwo.rpgaction.model.entities.User;
import com.dtwo.rpgaction.model.request.UserRequest;
import com.dtwo.rpgaction.model.response.GenericResponse;
import com.dtwo.rpgaction.repositories.UserRepository;
import com.dtwo.rpgaction.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserActivities extends BaseActivity {

    @Autowired
    UserRepository userRepository;
    UserMapper userMapper;

    @Override
    public Object doActivity(Object payload) {
        UserRequest request = (UserRequest) payload;
        User user = findUser(request.getUsername());

        if(user != null) {
            return updateUser(userMapper.userRequestToUpdateEntity(user, request));
        } else {
            throw new ActionException(AppConstants.USER_DOES_NOT_EXISTS);
        }
    }

    public User findUser(String payload) {
        return userRepository.findUserByUsername((String) payload);
    }

    public Object updateUser(User payload) {
        try {
            userRepository.save(payload);
        } catch (ActionException ex) {
            throw new ActionException(AppConstants.USER_ACTION_SAVE_USER_ERROR, ex);
        }

        return GenericResponse.builder().message(String.format(AppConstants.USER_CREATION_SUCCESS, payload.getUsername()))
                .status(HttpStatus.CREATED).build();
    }
}
