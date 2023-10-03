package com.springusers.rest.webservices.usersweb.services.controllers;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {
    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    @GetMapping(path = "/hello-world")
    public String getGreeting(){
        return "Hello World :)";
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public String helloWorldPathVariable(@PathVariable String name) {
        return String.format("Welcome, %s", name);
    }
    @GetMapping(path = "/hello-world-int")
    public String helloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",
                null, "Default Message", locale );
    }
}
