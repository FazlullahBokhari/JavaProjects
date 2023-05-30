package com.example.jdbc4.demojdbc4.DBManager;

import com.example.jdbc4.demojdbc4.DAOs.Person;
import com.example.jdbc4.demojdbc4.Request.CreateRequest;

import java.net.CacheRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBOperations {

    private static volatile Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;

    public static Connection getConnection() throws SQLException {

        if(connection == null){
            synchronized (DBOperations.class){
                if(connection == null){
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gfg","root","1234");
                }
            }
        }

        return connection;
    }

    public static void createTable(String name) throws SQLException{
        statement = connection.createStatement();

        boolean isCreated = statement.execute("CREATE TABLE " + name + " (id int PRIMARY KEY AUTO_INCREMENT, name VARCHAR(45), age INT, address VARCHAR(110))");

        if(isCreated){
            System.out.println("table "+name+" is successfully created!!!");
        }
    }

    public static void closeConnection() throws SQLException{
        if(connection != null){
            synchronized (DBOperations.class){
                if(connection != null){
                    connection.close();
                    connection = null;
                }
            }
        }

    }

    public static void insertPerson(CreateRequest request) throws SQLException{
        Person person = new Person(request.getName(), request.getAge(), request.getAddress());

        preparedStatement = connection.prepareStatement("insert into person values(null,?,?,?)");
        preparedStatement.setString(1,request.getName());
        preparedStatement.setInt(2,request.getAge());
        preparedStatement.setString(3,request.getAddress());

        int rows_affected = preparedStatement.executeUpdate();

        if(rows_affected>0){
            System.out.println("successfully inserted the record!!!");
        }else{
            System.out.println("unable to insert the record!!");
        }

        //statement = connection.createStatement();
        //int rows_affected = statement.executeUpdate("insert into person values()");

    }

    public static Person getPersonById(int id) throws SQLException{

        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from person where id=" + id);

        if(resultSet.next()){
            int person_id = resultSet.getInt(1);
            String personName = resultSet.getString(2);
            int age = resultSet.getInt(3);
            String address = resultSet.getString(4);

            Person person = new Person(person_id, personName, age, address);
            System.out.println(person);
            return person;
        }else{
            return null;
        }
    }

    public static List<Person> getPerson(String name) throws SQLException{

        // getting persons from db
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from " + name);

        List<Person> persons = new ArrayList<>();

        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String personName = resultSet.getString(2);
            int age = resultSet.getInt(3);
            String address = resultSet.getString(4);

            Person person = new Person(id, personName, age, address);
            System.out.println(person);

            persons.add(person);
        }


        return persons;
    }

    public static void deletePerson(int id) throws SQLException{

        statement = connection.createStatement();
        statement.executeUpdate("delete from person where id="+id);
    }

    public static void updatePerson(int id, CreateRequest request) throws SQLException{


        preparedStatement = connection.prepareStatement("update person set name=?, age=?, address=? where id=?");
        preparedStatement.setString(1,request.getName());
        preparedStatement.setInt(2,request.getAge());
        preparedStatement.setString(3,request.getAddress());
        preparedStatement.setInt(4,id);

       preparedStatement.executeUpdate();
    }
}
