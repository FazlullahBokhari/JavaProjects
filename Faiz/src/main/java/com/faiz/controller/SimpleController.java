package com.faiz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class SimpleController {

    @GetMapping("/hi")
    public String sayHi(){
        return "Hellow from our server";
    }

    @GetMapping("/search")
    public String searchAWord(@RequestParam String q){
        DataStore db = new DataStore();
        return db.getData(q);
    }


}
