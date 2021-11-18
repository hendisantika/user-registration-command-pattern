package com.hendisantika.config;

import com.hendisantika.entity.common.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created by IntelliJ IDEA.
 * Project : user-registration-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/11/21
 * Time: 06.24
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JPAConfig {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }
}
