package com.hendisantika.event.publisher;

import com.hendisantika.event.UserSource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : user-registration-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/11/21
 * Time: 06.05
 */
@Service
@EnableBinding(UserSource.class)
public class UserEventPublisherImpl implements UserEventPublisher {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSource userSource;

    @Autowired
    private ModelMapper modelMapper;
}
