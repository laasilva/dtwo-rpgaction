package com.dtwo.rpgaction.scopes.user.step1;

import com.dtwo.rpgaction.exception.ActionException;
import com.dtwo.rpgaction.exception.ValidationException;
import com.dtwo.rpgaction.model.entities.User;
import com.dtwo.rpgaction.model.request.UserRequest;
import com.dtwo.rpgaction.model.commons.ScopeContext;
import com.dtwo.rpgaction.repositories.UserRepository;
import com.dtwo.rpgaction.scopes.baseCommons.BaseScopeItem;
import com.dtwo.rpgaction.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRequestValidator extends BaseScopeItem {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Object processor(Object payload, ScopeContext context) {
        UserRequest userRequest = (UserRequest) payload;

        if(userRequest.getUsername().isEmpty() || userRequest.getUsername() == null) {
            throw new ValidationException(AppConstants.USER_VALIDATION_USERNAME_ERROR, HttpStatus.BAD_REQUEST);
        }

        if(userRequest.getPassword().isEmpty() || userRequest.getPassword() == null) {
            throw new ValidationException(AppConstants.USER_VALIDATION_PASSWORD_ERROR, HttpStatus.BAD_REQUEST);
        }

        if(userRequest.getEmail().isEmpty() || userRequest.getEmail() == null) {
            throw new ValidationException(AppConstants.USER_VALIDATION_PASSWORD_ERROR, HttpStatus.BAD_REQUEST);
        }

        List<User> users = userRepository.findUserByUsername(userRequest.getUsername());

        if(!users.isEmpty()) {
            throw new ActionException(AppConstants.USER_USERNAME_EXISTS_ERROR, HttpStatus.CONFLICT);
        }

        return payload;
    }
}
