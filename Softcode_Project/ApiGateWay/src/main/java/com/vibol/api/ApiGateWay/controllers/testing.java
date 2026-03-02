package com.vibol.api.ApiGateWay.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class testing {


    @GetMapping
    public String testing(){
        return "Testing with Api Gate Way";
    }
}
