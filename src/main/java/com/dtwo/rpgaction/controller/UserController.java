package com.dtwo.rpgaction.controller;

import com.dtwo.rpgaction.exception.GeneralControllerException;
import com.dtwo.rpgaction.model.request.UserRequest;
import com.dtwo.rpgaction.scopes.baseCommons.ScopeProcessor;
import com.dtwo.rpgaction.scopes.user.step1.FindUser;
import com.dtwo.rpgaction.utils.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@Component
public class UserController {

    @Resource(name = "newUserScope")
    ScopeProcessor createUserContext;

    @Resource(name = "findUserScope")
    FindUser findUserContext;

    @RequestMapping(value = {"/create"}, method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object createUser(@RequestBody UserRequest userRequest) {
        try {
            return ResponseEntity.ok(createUserContext.execute(userRequest));
        } catch (GeneralControllerException ex) {
            return new ResponseEntity<>(AppConstants.GENERIC_CONTROLLER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/find"}, method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object findUser(@RequestHeader String username) {
        try {
            return ResponseEntity.ok(findUserContext.execute(username));
        } catch (GeneralControllerException ex) {
            return new ResponseEntity<>(AppConstants.GENERIC_CONTROLLER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
