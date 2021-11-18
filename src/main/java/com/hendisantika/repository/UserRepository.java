package com.hendisantika.repository;

import com.hendisantika.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : user-registration-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/11/21
 * Time: 06.06
 */
@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

    Optional<User> findByUsername(String userName);
}
