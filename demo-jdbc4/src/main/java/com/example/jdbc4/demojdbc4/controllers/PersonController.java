package com.example.jdbc4.demojdbc4.controllers;

import com.example.jdbc4.demojdbc4.DAOs.Person;
import com.example.jdbc4.demojdbc4.DBManager.DBOperations;
import com.example.jdbc4.demojdbc4.Request.CreateRequest;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class PersonController {

    @RequestMapping(value = "/createTable", method = RequestMethod.POST)
    public void createTable(@RequestParam("name") String name) throws SQLException {
        DBOperations.getConnection();
        DBOperations.createTable(name);
        DBOperations.closeConnection();
    }

    @RequestMapping(value = "/getPersons", method = RequestMethod.GET)
    public List<Person> getPerson(@RequestParam("name") String name) throws SQLException{
        DBOperations.getConnection();
        List<Person> person = DBOperations.getPerson(name);
        DBOperations.closeConnection();
        //calling dao to get object from db

        return person;
    }

    @RequestMapping(value = "/insertPerson", method = RequestMethod.POST)
    public void inserPerson(@RequestBody CreateRequest request) throws SQLException{
        DBOperations.getConnection();
        DBOperations.insertPerson(request);
        DBOperations.closeConnection();

    }

    @DeleteMapping("/delete/{id}")
    public Person deletePerson(@PathVariable("id") int id) throws SQLException{
        DBOperations.getConnection();
        Person person = DBOperations.getPersonById(id);
        DBOperations.deletePerson(id);
        DBOperations.closeConnection();

        return person;
    }

    @GetMapping(value = "/getPerson/{id}")
    public Person getPersonById(@PathVariable("id") int id) throws SQLException{
        DBOperations.getConnection();
        Person personById = DBOperations.getPersonById(id);
        DBOperations.closeConnection();

        return personById;
    }


    @RequestMapping(value = "/updatePerson/{id}", method = RequestMethod.PATCH)
    public Person updatePerson(@PathVariable("id") int id,@RequestBody CreateRequest request, Person person) throws SQLException{
        DBOperations.getConnection();
        DBOperations.updatePerson(id,request);
        Person personById = DBOperations.getPersonById(id);
        DBOperations.closeConnection();
        return personById;
    }


}
