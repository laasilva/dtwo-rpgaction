package com.dtwo.rpgaction.services.activities;

import com.dtwo.rpgaction.exception.ActionException;
import com.dtwo.rpgaction.exception.ValidationException;
import com.dtwo.rpgaction.mapper.UserMapper;
import com.dtwo.rpgaction.mapper.UserMapperImpl;
import com.dtwo.rpgaction.model.entities.User;
import com.dtwo.rpgaction.model.enums.Role;
import com.dtwo.rpgaction.model.request.UserRequest;
import com.dtwo.rpgaction.model.response.GenericResponse;
import com.dtwo.rpgaction.repositories.UserRepository;
import com.dtwo.rpgaction.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class NewUserActivities extends BaseActivity {

    @Autowired
    UserRepository userRepository;
    UserMapper userMapper;

    @Override
    public Object doActivity(Object payload) {
        boolean validator = userRequestValidator((UserRequest) payload);

        if(validator) {
            return createUser((UserRequest) payload);
        } else {
            throw new ActionException(AppConstants.USER_USERNAME_EXISTS_ERROR);
        }
    }

    public NewUserActivities() {
        this.userMapper = new UserMapperImpl();
    }

    public boolean userRequestValidator(UserRequest request) {
        UserRequest userRequest = (UserRequest) request;

        if(userRequest.getUsername().isEmpty() || userRequest.getUsername() == null) {
            throw new ValidationException(AppConstants.USER_VALIDATION_USERNAME_ERROR, HttpStatus.BAD_REQUEST);
        }

        if(userRequest.getPassword().isEmpty() || userRequest.getPassword() == null) {
            throw new ValidationException(AppConstants.USER_VALIDATION_PASSWORD_ERROR, HttpStatus.BAD_REQUEST);
        }

        if(userRequest.getEmail().isEmpty() || userRequest.getEmail() == null) {
            throw new ValidationException(AppConstants.USER_VALIDATION_EMAIL_ERROR, HttpStatus.BAD_REQUEST);
        }

        User user = userRepository.findUserByUsername(userRequest.getUsername());

        return (user == null);
    }

    public Object createUser(UserRequest request) {
        User payload = userMapper.userRequestToEntity((UserRequest) request);
        try {
            userRepository.save(payload);
        } catch (ActionException ex) {
            throw new ActionException(AppConstants.USER_ACTION_SAVE_USER_ERROR, ex);
        }

        return GenericResponse.builder().message(String.format(AppConstants.USER_CREATION_SUCCESS, payload.getId(), payload.getUsername()))
                .status(HttpStatus.CREATED).build();
    }
}
