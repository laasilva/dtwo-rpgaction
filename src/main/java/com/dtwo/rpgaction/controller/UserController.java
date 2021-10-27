package com.dtwo.rpgaction.controller;

import com.dtwo.rpgaction.exception.GeneralControllerException;
import com.dtwo.rpgaction.model.request.UserRequest;
import com.dtwo.rpgaction.scopes.commons.ScopeProcessor;
import com.dtwo.rpgaction.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
@Component
public class UserController {

    @Autowired
    @Resource(name = "newUserScope")
    ScopeProcessor createUserContext;

    @RequestMapping(value = {"/create"}, method = RequestMethod.POST, produces="application/json")
    @ResponseBody
    public Object createUser(@RequestBody UserRequest userRequest) {
        try {
            return createUserContext.execute(userRequest);
        } catch (GeneralControllerException ex) {
            return new ResponseEntity<>(Constants.GENERIC_CONTROLLER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
