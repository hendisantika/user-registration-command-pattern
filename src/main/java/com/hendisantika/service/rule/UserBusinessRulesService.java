package com.hendisantika.service.rule;

import com.hendisantika.domain.commands.UserCreateDTO;

/**
 * Created by IntelliJ IDEA.
 * Project : user-registration-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/11/21
 * Time: 06.16
 */
public interface UserBusinessRulesService {
    boolean isUserNameAlreadyTaken(UserCreateDTO userCreateDTO);
}
