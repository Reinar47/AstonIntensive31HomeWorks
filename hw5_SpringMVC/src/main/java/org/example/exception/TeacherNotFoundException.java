package org.example.exception;

import javassist.NotFoundException;

public class TeacherNotFoundException extends NotFoundException {
    public TeacherNotFoundException() {
        super("Can't find any teachers");
    }
    public TeacherNotFoundException(long id) {
        super("Teacher with id " + id + " not found ");
    }

}
