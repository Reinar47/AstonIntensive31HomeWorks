package org.example.exception;

import javassist.NotFoundException;

public class StudentNotFoundException extends NotFoundException {

    public StudentNotFoundException(long id) {
        super("Student with id " + id + " not found ");
    }
    public StudentNotFoundException() {
        super("Can't find any students");
    }
}
