package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/addPerson").authenticated() // Require authentication for /addPerson
                .anyRequest().permitAll() // Allow access to all other endpoints
            )
            .httpBasic(Customizer.withDefaults()) // Enable Basic Auth
            .csrf(csrf -> csrf.disable()); // Disable CSRF protection using the new API

        return http.build();
    }
}