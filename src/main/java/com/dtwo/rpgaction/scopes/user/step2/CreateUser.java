package com.dtwo.rpgaction.scopes.user.step2;

import com.dtwo.rpgaction.exception.ActionException;
import com.dtwo.rpgaction.mapper.UserMapper;
import com.dtwo.rpgaction.mapper.UserMapperImpl;
import com.dtwo.rpgaction.model.commons.ScopeContext;
import com.dtwo.rpgaction.model.entities.User;
import com.dtwo.rpgaction.model.request.UserRequest;
import com.dtwo.rpgaction.model.response.GenericResponse;
import com.dtwo.rpgaction.repositories.UserRepository;
import com.dtwo.rpgaction.scopes.commons.BaseScopeItem;
import com.dtwo.rpgaction.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CreateUser extends BaseScopeItem {

    @Autowired
    private UserRepository userRepository;

    private UserMapper userMapper;

    public CreateUser() {
        userMapper = new UserMapperImpl();
    }

    @Override
    public Object processor(Object payload, ScopeContext context) throws ActionException {
        User user = userMapper.userRequestToEntity((UserRequest) payload);

        try {
            userRepository.save(user);
        } catch (ActionException ex) {
            throw new ActionException(Constants.USER_ACTION_SAVE_USER_ERROR, ex);
        }

        return GenericResponse.builder().message(String.format(Constants.USER_CREATION_SUCCESS, user.getId(), user.getUsername()))
                .status(HttpStatus.CREATED).build();
    }
}
