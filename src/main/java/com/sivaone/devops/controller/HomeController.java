package com.sivaone.devops.controller;

import com.sivaone.devops.usecase.GetGreetingUsecase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class HomeController {

    private final GetGreetingUsecase getGreetingUsecase;

    public HomeController(GetGreetingUsecase getGreetingUsecase) {
        this.getGreetingUsecase = getGreetingUsecase;
    }

    @GetMapping("/")
    public Map<String, String> home(@RequestParam(required = false) String name) {
        return Collections.singletonMap("message", getGreetingUsecase.greet(name));
    }
}
