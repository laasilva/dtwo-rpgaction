package com.dtwo.rpgaction.controller;

import com.dtwo.rpgaction.exception.GeneralControllerException;
import com.dtwo.rpgaction.model.request.UserRequest;
import com.dtwo.rpgaction.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import com.dtwo.rpgaction.services.UserService;

@RestController
@RequestMapping("/user")
@Component
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/create"}, method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object createUser(@RequestBody UserRequest userRequest) {
        try {
            return ResponseEntity.ok(userService.newUserActivities(userRequest));
        } catch (GeneralControllerException ex) {
            return new ResponseEntity<>(AppConstants.GENERIC_CONTROLLER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object updateUser(@RequestBody UserRequest userRequest) {
        try {
            return ResponseEntity.ok(userService.updateUserActivities(userRequest));
        } catch (GeneralControllerException ex) {
            return new ResponseEntity<>(AppConstants.GENERIC_CONTROLLER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/find"}, method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object findUser(@RequestHeader String username) {
        try {
            return ResponseEntity.ok(userService.findUserActivities(username));
        } catch (GeneralControllerException ex) {
            return new ResponseEntity<>(AppConstants.GENERIC_CONTROLLER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/findAll"}, method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object findAll() {
        try {
            return ResponseEntity.ok(userService.findAllUsersActivities());
        } catch (GeneralControllerException ex) {
            return new ResponseEntity<>(AppConstants.GENERIC_CONTROLLER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE,consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object delete(@RequestHeader String username) {
        try {
            return ResponseEntity.ok(userService.deleteUserActivities(username));
        } catch (GeneralControllerException ex) {
            return new ResponseEntity<>(AppConstants.GENERIC_CONTROLLER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
