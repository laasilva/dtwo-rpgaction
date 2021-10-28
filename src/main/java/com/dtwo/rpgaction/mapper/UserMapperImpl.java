package com.dtwo.rpgaction.mapper;

import com.dtwo.rpgaction.model.entities.User;
import com.dtwo.rpgaction.model.enums.Role;
import com.dtwo.rpgaction.model.request.UserRequest;
import com.dtwo.rpgaction.model.response.UserResponse;
import com.dtwo.rpgaction.utils.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserMapperImpl implements UserMapper {

    private PasswordEncoder passwordEncoder;

    public UserMapperImpl() {
        this.passwordEncoder = new PasswordEncoder();
    }

    @Override
    public User userRequestToEntity(UserRequest userRequest) {
        User userEntity = new User();

        userEntity.setUsername(userRequest.getUsername());
        userEntity.setPassword(passwordEncoder.encodePassword(userRequest.getPassword()));
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setRegistrationDate(new Date());
        userEntity.setRole(Role.USER);

        return userEntity;
    }

    @Override
    public User userRequestToUpdateEntity(User user, UserRequest userRequest) {

        return User.builder().id(user.getId())
                .username(userRequest.getUsername() == null ? user.getUsername() : userRequest.getUsername())
                .password(userRequest.getPassword() == null ? user.getPassword() : userRequest.getPassword())
                .email(userRequest.getEmail() == null ? user.getEmail() : userRequest.getEmail())
                .role(userRequest.getRole() == null ? user.getRole() : Role.getRoleByIdOrDescription(Long.valueOf(userRequest.getRole()))).build();
    }

    @Override
    public List<UserResponse> entityListToResponseList(List<User> users) {
        List<UserResponse> response = new ArrayList<>();
        users.forEach(user -> {
            response.add(UserResponse.builder().id(user.getId())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .registrationDate(user.getRegistrationDate())
                    .role(user.getRole()
                    .getDescription()).build());
        });

        return response;
    }
}
