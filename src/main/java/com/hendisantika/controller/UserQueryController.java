package com.hendisantika.controller;

import com.hendisantika.domain.queries.UserQueryDTO;
import com.hendisantika.service.query.UserQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @GetMapping(value = "/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Returns a specific user based on username")
    private ResponseEntity<UserQueryDTO> getUserByUserName(@ApiParam("User Name for which details should be fetched")
                                                           @PathVariable(value = "userName") String userName) {
        log.info("GET request received for username: " + userName);
        return new ResponseEntity<>(userQueryService.findByUserName(userName), HttpStatus.OK);
    }
}
