package com.faiz.controller;

import java.util.HashMap;

public class DataStore {

    private HashMap<String, String> store = new HashMap<String, String>();

    public DataStore(){
        store.put("Faiz", "Java developer");
        store.put("Rahul", "Sharukh khan of PSA institute");
        store.put("Deen", "Hrithic Roshan of Lovely");
    }

    public String getData(String word){
        return store.get(word);
    }

}
