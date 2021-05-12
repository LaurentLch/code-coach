package com.noobs.codecoach.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping (path = "/hello")
public class HelloWorldController {


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String returnHelloWorld(){
        return "hello, world!";
    }

}
