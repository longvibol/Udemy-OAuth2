package com.vibol.api.ResourceServer.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

@Configuration
@EnableWebSecurity
// Use to enable spring security
public class WebSecurity{

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception{

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeyCloakConverter());

        // Create object with filter chain
        http.authorizeHttpRequests(authz ->
                        authz
                                .requestMatchers(HttpMethod.GET,"/users/status/check")
//                                .hasAuthority("SCOPE_profile")
                                .hasRole("developer1")
//                                .hasAnyRole("USER","ADMIN")
                                .anyRequest().authenticated())
                .oauth2ResourceServer(oauth2 ->
                        oauth2.jwt(jwt ->
                                jwt.jwtAuthenticationConverter(jwtAuthenticationConverter)));
        return http.build();
    }
}































