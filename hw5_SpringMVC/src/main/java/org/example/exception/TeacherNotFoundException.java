package com.example.rest.temp.hw5_SpringMVC.src.main.java.org.example.exception;

public class TeacherNotFoundException extends NotFoundException{
    public TeacherNotFoundException() {
        super("Can't find any teachers");
    }
    public TeacherNotFoundException(long id) {
        super("Teacher with id " + id + " not found ");
    }

}
