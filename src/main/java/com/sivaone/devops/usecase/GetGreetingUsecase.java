package com.sivaone.devops.usecase;

import org.springframework.stereotype.Service;

@Service
public class GetGreetingUsecase {

    public String greet(final String name) {
        final String greet = (name == null || name.isBlank()) ? "there!" : name.trim();
        return "Hello " + greet;
    }
}
