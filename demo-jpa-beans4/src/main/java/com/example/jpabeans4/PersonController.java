package com.example.jpabeans4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    HelloWorld helloWorld;

    @GetMapping("/func")
    public HelloWorld func(){
        System.out.println(helloWorld);
        return helloWorld;
    }
}
