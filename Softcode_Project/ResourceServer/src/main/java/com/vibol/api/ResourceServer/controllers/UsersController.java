package com.vibol.api.ResourceServer.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Slf4j
public class UsersController {

    @GetMapping("/status/check")
    public String status(){
        log.info("Request From scope profile");
        return "Working...";
    }
}

