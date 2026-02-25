package com.vibol.api.ResourceServer.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
// Use to enable spring security
public class WebSecurity {

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception{
        return http.build();
    }
}


