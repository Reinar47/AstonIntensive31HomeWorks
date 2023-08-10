package org.example.exception;

public abstract class NotFoundException extends Exception {

    public NotFoundException(String message) {
        super(message);
    }
}
