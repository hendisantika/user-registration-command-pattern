package com.hendisantika.event.snapshot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : user-registration-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/11/21
 * Time: 06.08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEventSnapshot {
    private UUID id;

    private String userName;

    private String firstName;

    private String lastName;

    private String email;

    private String state;

    private String verificationToken;

    @Override
    public String toString() {
        return "UserEventSnapshot{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", state='" + state + '\'' +
                ", verificationToken='" + verificationToken + '\'' +
                '}';
    }
}
