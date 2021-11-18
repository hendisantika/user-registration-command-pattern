package com.hendisantika.service.command;

import com.hendisantika.domain.commands.UserCreateDTO;
import com.hendisantika.domain.commands.UserUpdateDTO;

/**
 * Created by IntelliJ IDEA.
 * Project : user-registration-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/11/21
 * Time: 06.14
 */

public interface UserCommandService {
    String createUser(UserCreateDTO newUser);

    String updateUser(String userName, UserUpdateDTO updateUser);

    String updatePassword(String userName, String newPassword);

    String deleteUser(String userName);
}
