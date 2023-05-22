package com.faiz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


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

    DBUser dbUser = new DBUser();

    @GetMapping("/users")
    public List<User> getUser(){
        return dbUser.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getAUser(@PathVariable int id){
        return dbUser.getAUser(id);
    }

    @GetMapping("/user")
    public User getUser(@RequestParam int id){
        return dbUser.getAUser(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        User savedUser = dbUser.addUser(user);
        return savedUser;
    }


    @GetMapping("/users/status/{id}")
    public ResponseEntity<User> getStatusUser(@PathVariable int id){
        User user = dbUser.getAUser(id);
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        header.put("serverCreated", Collections.singletonList("CodeofFaiz"));
        HttpStatus status = HttpStatus.CREATED;
        ResponseEntity<User> response = new ResponseEntity<User>(user, header, status);

        return response;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id){
        boolean b = dbUser.deleteUser(id);
        return "User deleted with id: "+id;
    }

}
