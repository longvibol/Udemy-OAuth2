package com.vibol.clients.PhotoAppWebClient.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/css/**", "/js/**", "/force-login").permitAll()
                .requestMatchers(HttpMethod.GET, "/albums/**").authenticated()
                .anyRequest().authenticated()
        )
        .oauth2Login(oauth -> oauth
                .loginPage("/oauth2/authorization/mywebclient")
                .successHandler(forceLoginRedirectHandler())
        )
        .logout(logout -> logout.logoutSuccessUrl("/"));

        return http.build();
    }

    @Bean
    AuthenticationSuccessHandler forceLoginRedirectHandler() {
        return (request, response, authentication) -> response.sendRedirect("/albums");
    }
}