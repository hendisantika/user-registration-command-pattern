package com.hendisantika.event.publisher;

import com.hendisantika.event.model.UserCreatedEvent;

/**
 * Created by IntelliJ IDEA.
 * Project : user-registration-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/11/21
 * Time: 06.05
 */
public interface UserEventPublisher {
    void handleUserCreatedEvent(UserCreatedEvent userCreatedEvent);
}
