package com.hendisantika;

import com.hendisantika.domain.commands.UserCreateDTO;
import com.hendisantika.service.command.UserCommandService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@EnableEurekaClient
public class UserRegistrationCommandPatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserRegistrationCommandPatternApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserCommandService userCommandService) {
        return (evt) -> Arrays.asList(
                "user,admin,naruto,sasuke,sakura".split(",")).forEach(
                username -> {
                    UserCreateDTO userCreateDTO = new UserCreateDTO();
                    userCreateDTO.setUserName(username);
                    userCreateDTO.setPassword("password123");
                    userCreateDTO.setFirstName(username);
                    userCreateDTO.setLastName("Konoha");
                    userCommandService.createUser(userCreateDTO);

                }
        );
    }
}
