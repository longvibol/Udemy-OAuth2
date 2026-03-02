package com.vibol.api.ResourceServer.controllers;

import com.vibol.api.ResourceServer.response.UserRest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UsersController {

    @GetMapping("/status/check")
    public String status(){
        log.info("Request From scope profile");
        return "Working... from Resource Server";
    }

//    @PreAuthorize("hasAuthority('ROLE_developer') or #id == #jwt.subject")
    @PreAuthorize("#id == #jwt.subject")
//    @PreAuthorize("hasRole('developer')")
//    @Secured("ROLE_developer")
    @DeleteMapping(path="/{id}")
    public String deletedUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt){
        return "Deleted user with id: " + id + " and JWT subject " + jwt.getSubject();
    }

    @PostAuthorize("returnObject.userId == #jwt.subject")
    @GetMapping(path="/{id}")
    public UserRest getUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt){
        return new UserRest("Vibol","long","80373687-a5e1-43d6-bbd8-36d421e760c");
    }

}
