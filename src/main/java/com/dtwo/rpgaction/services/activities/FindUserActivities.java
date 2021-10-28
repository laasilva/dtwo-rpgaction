package com.dtwo.rpgaction.services.activities;

import com.dtwo.rpgaction.model.entities.User;
import com.dtwo.rpgaction.model.response.GenericResponse;
import com.dtwo.rpgaction.model.response.UserResponse;
import com.dtwo.rpgaction.repositories.UserRepository;
import com.dtwo.rpgaction.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class FindUserActivities extends BaseActivity {

    @Autowired
    UserRepository userRepository;

    @Override
    public Object doActivity(Object payload) {
        return findUser((String) payload);
    }

    public Object findUser(String payload) {

        User user = userRepository.findUserByUsername((String) payload);

        if(user != null) {
            return UserResponse.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .registrationDate(user.getRegistrationDate())
                    .role(user.getRole().getDescription()).build();
        } else {
            return GenericResponse.builder()
                    .message(String.format(AppConstants.USER_DOES_NOT_EXISTS, (String) payload))
                    .status(HttpStatus.NO_CONTENT).build();
        }
    }
}
