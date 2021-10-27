package com.dtwo.rpgaction.scopes.user;

import com.dtwo.rpgaction.exception.ActionException;
import com.dtwo.rpgaction.exception.ValidationException;
import com.dtwo.rpgaction.model.entities.User;
import com.dtwo.rpgaction.model.request.UserRequest;
import com.dtwo.rpgaction.model.commons.ScopeContext;
import com.dtwo.rpgaction.repositories.UserRepository;
import com.dtwo.rpgaction.scopes.commons.BaseScopeItem;
import com.dtwo.rpgaction.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class UserRequestValidator extends BaseScopeItem {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Object processor(Object payload, ScopeContext context) {
        UserRequest userRequest = (UserRequest) payload;

        if(userRequest.getUsername().isEmpty() || userRequest.getUsername() == null) {
            throw new ValidationException(Constants.USER_VALIDATION_USERNAME_ERROR, HttpStatus.BAD_REQUEST);
        }

        if(userRequest.getPassword().isEmpty() || userRequest.getPassword() == null) {
            throw new ValidationException(Constants.USER_VALIDATION_PASSWORD_ERROR, HttpStatus.BAD_REQUEST);
        }

        List<User> users = userRepository.findUserByUsername(userRequest.getUsername());

        if(!users.isEmpty()) {
            throw new ActionException(Constants.USER_USERNAME_EXISTS_ERROR, HttpStatus.CONFLICT);
        }

        return payload;
    }
}
