package org.example.exception;

public class StudentNotFoundException extends NotFoundException {

    public StudentNotFoundException(String courseName) {
        super("Students from" + courseName + " not found ");
    }
}
