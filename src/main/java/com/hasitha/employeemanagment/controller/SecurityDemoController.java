package com.hasitha.employeemanagment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityDemoController {

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Sri Lanka";
    }

    @GetMapping("/greeting")
    public String greeting(){
        return "Ayubowan !!!";
    }

    @GetMapping("/nonSecure")
    public String nonSecure(){
        return "Visit Sri Lanka !!!";
    }
}
