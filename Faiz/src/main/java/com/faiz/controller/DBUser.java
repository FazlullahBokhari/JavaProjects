package com.faiz.controller;

import java.util.ArrayList;
import java.util.List;

public class DBUser {

    private List<User> userTable = new ArrayList<User>();



    public DBUser(){
        userTable.add(new User(1, "Faiz", 26));
        userTable.add(new User(2, "Fazlu", 24));

    }

    public List<User> getAllUsers(){
        return userTable;
    }

    public User getAUser(int id){
        for(User user: userTable){
            if(user.getId() == id) return user;
        }
        return null;
    }
    public User addUser(User user){
        userTable.add(user);
        return user;
    }

    public boolean deleteUser(int id){
        for(User user: userTable){
            if(user.getId() == (id)){
                userTable.remove(id);
                return true;
            }
        }
        return false;
    }
}
