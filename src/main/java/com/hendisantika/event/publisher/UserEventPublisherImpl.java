package com.hendisantika.event.publisher;

import com.hendisantika.entity.User;
import com.hendisantika.event.UserSource;
import com.hendisantika.event.model.UserCreatedEvent;
import com.hendisantika.event.snapshot.UserEventSnapshot;
import com.hendisantika.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * Created by IntelliJ IDEA.
 * Project : user-registration-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/11/21
 * Time: 06.05
 */
@Log4j2
@Service
@EnableBinding(UserSource.class)
public class UserEventPublisherImpl implements UserEventPublisher {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSource userSource;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleUserCreatedEvent(UserCreatedEvent userCreatedEvent) {
        User createdUser = userRepository.findById(userCreatedEvent.getId()).get();
        log.info(createdUser.getVerification().toString());

        UserEventSnapshot userEventSnapshot = new UserEventSnapshot(createdUser.getId(),
                createdUser.getUsername(),
                createdUser.getFirstName(),
                createdUser.getLastName(),
                createdUser.getEmail(),
                createdUser.getStatus(),
                createdUser.getVerification().getToken());

        log.info(userEventSnapshot);

        userSource.userChannel().send(MessageBuilder.withPayload(userEventSnapshot).build());
    }
}
