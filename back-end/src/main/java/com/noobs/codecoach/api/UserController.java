package com.noobs.codecoach.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users", produces = "application/json")
public class UserController {

    @GetMapping(produces = "application/json")
    public String returnString() {
        return "Hello World!";
    }
}
