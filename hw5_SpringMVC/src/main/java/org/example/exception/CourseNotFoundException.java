package com.example.rest.temp.hw5_SpringMVC.src.main.java.org.example.exception;

public class CourseNotFoundException extends NotFoundException {

    public CourseNotFoundException(long id) {
        super("Cannot find course by id = " + id);
    }
    public CourseNotFoundException(String courseName) {
        super("Cannot find course by name = " + courseName);
    }
     public CourseNotFoundException() {
        super("No courses found !");
    }

}
