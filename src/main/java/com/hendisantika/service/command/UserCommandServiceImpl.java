package com.hendisantika.service.command;

import com.hendisantika.domain.commands.UserCreateDTO;
import com.hendisantika.domain.commands.UserUpdateDTO;
import com.hendisantika.entity.Role;
import com.hendisantika.entity.User;
import com.hendisantika.entity.UserStatus;
import com.hendisantika.entity.UserVerification;
import com.hendisantika.exception.UserIdNotAvailableException;
import com.hendisantika.repository.UserRepository;
import com.hendisantika.repository.UserVerificationRepository;
import com.hendisantika.service.rule.UserBusinessRulesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : user-registration-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/11/21
 * Time: 06.15
 */
@Service
public class UserCommandServiceImpl implements UserCommandService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserVerificationRepository userVerificationRepository;

    @Autowired
    private UserBusinessRulesService userBusinessRulesService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public String createUser(UserCreateDTO user) {
        if (userBusinessRulesService.isUserNameAlreadyTaken(user)) {
            throw new UserIdNotAvailableException("User Id " + user.getUserName() + " is already taken");
        }
        //Initializing the objects and mapping data
        User newUser = modelMapper.map(user, User.class);
        UserVerification newUserVerification = new UserVerification(UUID.randomUUID(), UUID.randomUUID().toString(),
                newUser);

        newUser.setId(UUID.randomUUID());
        newUser.setStatus(String.valueOf(UserStatus.HOLD));
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.grantAuthority(Role.ROLE_USER);
        if (user.getUserName().equals("admin"))
            newUser.grantAuthority(Role.ROLE_ADMIN);
        newUser.setVerification(newUserVerification);

        newUser = userRepository.save(newUser.createUser());

        return newUser.getUsername();
    }

    @Override
    @Transactional
    public String updateUser(String userName, UserUpdateDTO updateUser) {
        Optional<User> user = userRepository.findByUsername(userName);

        if (user.isPresent()) {
            user.get().setFirstName(updateUser.getFirstName());
            user.get().setLastName(updateUser.getLastName());
            user.get().setEmail(updateUser.getEmail());

            return userRepository.save(user.get()).getUsername();
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public String updatePassword(String userName, String newPassword) {
        return null;
    }

    @Override
    public String deleteUser(String userName) {
        return null;
    }
}
