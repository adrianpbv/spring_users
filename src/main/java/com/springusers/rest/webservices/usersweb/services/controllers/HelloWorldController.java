package com.springusers.rest.webservices.usersweb.services.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String getGreeting(){
        return "Hello World :)";
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public String helloWorldPathVariable(@PathVariable String name) {
        return String.format("Welcome, %s", name);
    }
}
