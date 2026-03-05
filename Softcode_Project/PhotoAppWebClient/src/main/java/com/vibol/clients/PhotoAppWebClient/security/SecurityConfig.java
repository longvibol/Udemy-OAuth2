package com.vibol.clients.PhotoAppWebClient.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

//@Configuration
public class SecurityConfig {

	@Bean 
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(auth -> 
			auth.requestMatchers("/", "/css/**", "/js/**", "/force-login").permitAll()
				.anyRequest().authenticated()).oauth2Login(Customizer.withDefaults())
				.logout(logout -> logout.logoutSuccessUrl("/"));

		return http.build();
	}


	@Bean
	AuthenticationSuccessHandler forceLoginRedirectHandler() {
		return (request, response, authentication) -> {
			// default behavior after login can be changed here if you want
			response.sendRedirect("/albums");
		};
	}
}