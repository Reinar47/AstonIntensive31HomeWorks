package org.example.exception;

public class TeacherNotFoundException extends NotFoundException {

    public TeacherNotFoundException(String courseName) {
        super("Teachers from" + courseName + " not found ");
    }
}
