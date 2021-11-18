package com.hendisantika.service.rule;

import com.hendisantika.domain.commands.UserCreateDTO;
import com.hendisantika.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : user-registration-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/11/21
 * Time: 06.17
 */
@Service
public class UserBusinessRulesServiceImpl implements UserBusinessRulesService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isUserNameAlreadyTaken(UserCreateDTO userCreateDTO) {
        return userRepository.findByUsername(userCreateDTO.getUserName()).isPresent();
    }

}
