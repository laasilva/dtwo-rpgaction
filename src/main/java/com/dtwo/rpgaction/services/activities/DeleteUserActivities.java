package com.dtwo.rpgaction.services.activities;

import com.dtwo.rpgaction.exception.ActionException;
import com.dtwo.rpgaction.model.entities.User;
import com.dtwo.rpgaction.model.response.GenericResponse;
import com.dtwo.rpgaction.repositories.UserRepository;
import com.dtwo.rpgaction.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserActivities extends BaseActivity {

    @Autowired
    UserRepository userRepository;

    @Override
    public Object doActivity(Object payload) {
        User user = findUser((String) payload);

        if(user != null) {
            return deleteUser(user);
        } else {
            throw new ActionException(AppConstants.USER_ACTION_DELETE_USER_ERROR);
        }
    }

    public User findUser(String payload) {
        return userRepository.findUserByUsername((String) payload);
    }

    public Object deleteUser(User payload) {
        try {
            userRepository.delete(payload);
        } catch (ActionException ex) {
            throw new ActionException(AppConstants.USER_ACTION_DELETE_USER_ERROR, ex);
        }

        return GenericResponse.builder().message(String.format(AppConstants.USER_DELETE_SUCCESS, payload.getId(), payload.getUsername()))
                .status(HttpStatus.OK).build();
    }
}
