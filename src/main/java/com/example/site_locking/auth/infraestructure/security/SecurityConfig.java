package com.example.site_locking.auth.infraestructure.security;

import com.example.site_locking.auth.domain.UserRole;
import com.example.site_locking.auth.infraestructure.persistence.entity.User;
import com.example.site_locking.auth.infraestructure.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain (HttpSecurity http,
                                             RestUsernamePasswordAuthenticationFilter restUsernamePasswordAuthenticationFilter)throws Exception{
        http
                .csrf(AbstractHttpConfigurer::disable)
                .securityContext(context->context.requireExplicitSave(false))
                .authorizeHttpRequests(auth -> auth
                        //.requestMatchers("/api/auth/login")
                        //.permitAll()
                        .requestMatchers(
                                "/css/**",
                                "/js/**",
                                "/image/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .addFilterAt(restUsernamePasswordAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)

                .formLogin((form) -> form
                        .loginPage("/login")
                        //.loginProcessingUrl("/login")
                        .permitAll()
                );
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner initDataBase(UserRepository userRepository,
                                   PasswordEncoder passwordEncoder){
        return args ->{
            if (userRepository.count()==0){
                User user1 = new User();
                user1.setUsername("Saimnh");
                user1.setPassword(passwordEncoder.encode("1234"));
                user1.setRole(UserRole.ROLE_INFLUENCER);

                User brand1 = new User();
                brand1.setUsername("Guedes");
                brand1.setPassword(passwordEncoder.encode("eletrica"));
                brand1.setRole(UserRole.ROLE_BRAND);

                userRepository.saveAll(List.of(user1,brand1));
            }
        };
    }
}
