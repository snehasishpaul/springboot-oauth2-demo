package com.snehasish.oauth.demo.config;

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
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security.csrf(Customizer.withDefaults())
                .cors(Customizer.withDefaults())
                        .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                                .oauth2Login(Customizer.withDefaults());

        return security.build();
    }
}
