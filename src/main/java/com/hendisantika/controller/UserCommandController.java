package com.hendisantika.controller;

import com.hendisantika.event.UserSource;
import com.hendisantika.service.command.UserCommandService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
