package com.dtwo.rpgaction.services.activities;

import com.dtwo.rpgaction.mapper.UserMapper;
import com.dtwo.rpgaction.mapper.UserMapperImpl;
import com.dtwo.rpgaction.model.entities.User;
import com.dtwo.rpgaction.model.response.GenericResponse;
import com.dtwo.rpgaction.repositories.UserRepository;
import com.dtwo.rpgaction.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllUsersActivities extends BaseActivity {

    @Autowired
    UserRepository userRepository;
    UserMapper userMapper = new UserMapperImpl();

    @Override
    public Object doActivity(Object payload) {
        return findAllUsers();
    }

    public Object findAllUsers() {

        List<User> user = userRepository.findAll();

        if(!user.isEmpty() || user != null) {
            return userMapper.entityListToResponseList(user);
        } else {
            return GenericResponse.builder()
                    .message(AppConstants.NO_USERS_ON_DATABASE)
                    .status(HttpStatus.NO_CONTENT).build();
        }
    }
}
