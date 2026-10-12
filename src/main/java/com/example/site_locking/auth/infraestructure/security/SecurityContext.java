package com.example.site_locking.auth.infraestructure.security;

import com.example.site_locking.auth.infraestructure.repository.UserRepository;
import org.hibernate.boot.model.process.internal.UserTypeResolution;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityContext {
    /*
    private final UserRepository userRepository;

    public SecurityContext(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    SecurityContext context = (SecurityContext) SecurityContextHolder.createEmptyContext();

    Authentication authentication =
            new TestingAuthenticationToken(
                    "username",
                    "password",
                    "ROLE_USER"
            );
    context.setAuthentication(authentication);

    SecurityContextHolder.setContext(context);*/
}
