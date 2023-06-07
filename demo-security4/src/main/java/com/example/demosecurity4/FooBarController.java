package com.example.demosecurity4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooBarController {

    //This required authentication and autherization as well
    @GetMapping("/foo")
    public String getFoo(){
        return "hello foo";
    }

    //This required authentication and autherization as well
    @GetMapping("/bar")
    public String getBar(){
        return "hello bar";
    }

    //my_role1 --> /foo

    //mu_role2 --> /bar*, /foo

    //This required authentication and autherization as well
    @GetMapping("/student")
    public String geStudent(){
        return "hello student";
    }

    //This required authentication and autherization as well
    @GetMapping("/admin")
    public String getAdmin(){
        return "hello Admin";
    }

    //This api does not required authentication or autherization
    @GetMapping("/visitor")
    public String getVisitor(){
        return "hello visitor";
    }
}
