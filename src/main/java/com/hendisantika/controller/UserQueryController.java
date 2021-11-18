package com.hendisantika.controller;

import com.hendisantika.service.query.UserQueryService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : user-registration-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/11/21
 * Time: 06.33
 */
@Log4j2
@RestController
@RequestMapping(value = "/api/users")
@Api(value = "User Queries", description = "Read user details", tags = "User Queries")
public class UserQueryController {

    @Autowired
    private UserQueryService userQueryService;

}
