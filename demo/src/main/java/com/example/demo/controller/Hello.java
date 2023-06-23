package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class Hello {

    @GetMapping("/helloworld")
    public String sayHello(){
        return "Hello World!";
    }

}
