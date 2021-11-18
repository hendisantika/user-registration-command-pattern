package com.hendisantika.exception;

/**
 * Created by IntelliJ IDEA.
 * Project : user-registration-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/11/21
 * Time: 06.13
 */
public class UserIdNotAvailableException extends RuntimeException {

    public UserIdNotAvailableException(String message) {
        super(message);
    }
}
