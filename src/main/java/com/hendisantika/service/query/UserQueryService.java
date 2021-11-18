package com.hendisantika.service.query;

import com.hendisantika.domain.queries.UserQueryDTO;

/**
 * Created by IntelliJ IDEA.
 * Project : user-registration-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/11/21
 * Time: 06.22
 */
public interface UserQueryService {

    UserQueryDTO findByUserName(String userName);
}
