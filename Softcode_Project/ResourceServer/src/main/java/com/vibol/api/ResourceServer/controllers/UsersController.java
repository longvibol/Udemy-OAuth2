package com.vibol.api.ResourceServer.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UsersController {

    @GetMapping("/status/check")
    public String status(){
        log.info("Request From scope profile");
        return "Working...";
    }

    @PreAuthorize("hasAuthority('ROLE_developer')")
//    @PreAuthorize("hasRole('developer')")
//    @Secured("ROLE_developer")
    @DeleteMapping(path="/{id}")
    public String deletedUser(@PathVariable String id){
        return "Deleted user with id: " + id;
    }
}

