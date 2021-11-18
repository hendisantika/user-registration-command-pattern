package com.hendisantika.event;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by IntelliJ IDEA.
 * Project : user-registration-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/11/21
 * Time: 06.03
 */
public interface UserSource {

    @Output("userChannel")
    MessageChannel userChannel();
}
