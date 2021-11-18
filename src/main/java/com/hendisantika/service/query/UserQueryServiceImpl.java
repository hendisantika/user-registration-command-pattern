package com.hendisantika.service.query;

import com.hendisantika.domain.queries.UserQueryDTO;
import com.hendisantika.entity.User;
import com.hendisantika.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : user-registration-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/11/21
 * Time: 06.22
 */
@Service
public class UserQueryServiceImpl implements UserQueryService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserQueryDTO findByUserName(String userName) {

        Optional<User> user = userRepository.findByUsername(userName);

        if (user.isPresent()) {
            return modelMapper.map(user.get(), UserQueryDTO.class);
        } else {
            throw new EntityNotFoundException();
        }

    }
}
