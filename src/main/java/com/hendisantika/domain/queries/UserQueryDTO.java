package com.hendisantika.domain.queries;

import com.hendisantika.entity.UserStatus;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : user-registration-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/11/21
 * Time: 05.53
 */
@Data
public class UserQueryDTO {
    private String userName;

    private String firstName;

    private String lastName;

    private String email;

    private UserStatus status;
}
