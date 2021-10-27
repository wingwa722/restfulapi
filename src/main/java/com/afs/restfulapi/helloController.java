package com.afs.restfulapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class helloController {

    @GetMapping
    public String helloWorld(){
        return "hello world";
    }
}
