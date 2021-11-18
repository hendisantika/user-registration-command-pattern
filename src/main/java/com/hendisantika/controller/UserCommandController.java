package com.hendisantika.controller;

import com.hendisantika.domain.commands.UserCreateDTO;
import com.hendisantika.event.UserSource;
import com.hendisantika.service.command.UserCommandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by IntelliJ IDEA.
 * Project : user-registration-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/11/21
 * Time: 06.35
 */
@RestController
@RequestMapping(value = "/api/users")
@Api(value = "User Commands", description = "Create, Update or Delete a User", tags = "User Commands")
@EnableBinding(UserSource.class)
public class UserCommandController {

    @Autowired
    private UserCommandService userCommandService;

    @Autowired
    private UserSource userSource;

    @PostMapping
    @ApiOperation("Registers a new user")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<String> createNewUser(@Valid @RequestBody UserCreateDTO userCreateDTO) {
        return new ResponseEntity<>("New User Created: " + userCommandService.createUser(userCreateDTO),
                HttpStatus.CREATED);
    }
}
