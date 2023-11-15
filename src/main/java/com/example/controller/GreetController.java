package com.example.controller;

import com.example.service.GreetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    private final GreetService greetService;

    public GreetController(GreetService greetService) {
        this.greetService = greetService;
    }

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name, @RequestParam(required = false, defaultValue = "en") String locale) {
        return greetService.getGreeting(name, locale);
    }
}
