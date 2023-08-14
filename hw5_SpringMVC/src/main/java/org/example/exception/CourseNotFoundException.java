package org.example.exception;

import javassist.NotFoundException;

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
