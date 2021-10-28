package com.dtwo.rpgaction.services;

import com.dtwo.rpgaction.model.request.UserRequest;
import com.dtwo.rpgaction.services.activities.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired NewUserActivities newUserActivities;
    @Autowired FindUserActivities findUserActivities;
    @Autowired FindAllUsersActivities findAllUserActivities;
    @Autowired DeleteUserActivities deleteUserActivities;
    @Autowired UpdateUserActivities updateUserActivities;

    public Object newUserActivities(UserRequest request) {
        Object response = newUserActivities.doActivity(request);

        return response;
    }

    public Object updateUserActivities(UserRequest request) {
        Object response = updateUserActivities.doActivity(request);

        return response;
    }

    public Object findUserActivities(String request) {
        Object response = findUserActivities.doActivity(request);

        return response;
    }

    public Object findAllUsersActivities() {
        Object response = findAllUserActivities.doActivity(null);

        return response;
    }

    public Object deleteUserActivities(String request) {
        Object response = deleteUserActivities.doActivity(request);

        return response;
    }
}
