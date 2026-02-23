package com.vibol.api.ResourceServer.controllers;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/token")
public class TokenController {

    @GetMapping("map")
    public Map<String, Object> getTokenObject(@AuthenticationPrincipal Jwt jwt ){
        return Collections.singletonMap("Principal", jwt);
    }

    @GetMapping("jwt")
    public Jwt getToken(@AuthenticationPrincipal Jwt jwt){
        return jwt;
    }

}
