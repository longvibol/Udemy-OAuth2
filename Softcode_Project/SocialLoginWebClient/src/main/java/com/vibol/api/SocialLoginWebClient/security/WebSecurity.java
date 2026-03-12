package com.vibol.api.SocialLoginWebClient.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurity {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/css/**", "/js/**", "/force-login").permitAll()
                .anyRequest().authenticated()
        )
        .oauth2Login(oauth -> oauth
                .loginPage("/oauth2/authorization/google")
        )
        .logout(logout -> logout
                .logoutUrl("/logout")
//                .logoutSuccessUrl("/about")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
        );

        return http.build();
    }
}