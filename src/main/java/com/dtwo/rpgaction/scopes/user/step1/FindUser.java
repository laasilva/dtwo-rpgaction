package com.dtwo.rpgaction.scopes.user.step1;

import com.dtwo.rpgaction.mapper.UserMapper;
import com.dtwo.rpgaction.mapper.UserMapperImpl;
import com.dtwo.rpgaction.model.commons.ScopeContext;
import com.dtwo.rpgaction.model.entities.User;
import com.dtwo.rpgaction.model.response.GenericResponse;
import com.dtwo.rpgaction.model.response.UserResponse;
import com.dtwo.rpgaction.repositories.UserRepository;
import com.dtwo.rpgaction.scopes.baseCommons.BaseScopeItem;
import com.dtwo.rpgaction.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public class FindUser extends BaseScopeItem {

    @Autowired
    private UserRepository userRepository;

    private UserMapper userMapper;

    public FindUser() {
        userMapper = new UserMapperImpl();
    }
    @Override
    public Object processor(Object currentPayload, ScopeContext context) {

        User user = userRepository.findUserByUsername((String) currentPayload);

        if(user != null) {
            return UserResponse.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .registrationDate(user.getRegistrationDate()).build();
        } else {
            return GenericResponse.builder()
                    .message(String.format(AppConstants.USER_DOES_NOT_EXISTS, (String) currentPayload))
                    .status(HttpStatus.NO_CONTENT).build();
        }
    }
}
