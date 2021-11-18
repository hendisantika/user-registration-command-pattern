package com.hendisantika.repository;

import com.hendisantika.entity.UserVerification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : user-registration-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/11/21
 * Time: 06.07
 */
@Repository
public interface UserVerificationRepository extends CrudRepository<UserVerification, UUID> {
}
