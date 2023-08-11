package com.example.rest.temp.hw5_SpringMVC.src.main.java.org.example.exception;

public class StudentNotFoundException extends NotFoundException {

    public StudentNotFoundException(long id) {
        super("Student with id " + id + " not found ");
    }
    public StudentNotFoundException() {
        super("Can't find any students");
    }
}
