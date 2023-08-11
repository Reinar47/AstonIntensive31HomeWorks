package com.example.rest.temp.hw5_SpringMVC.src.main.java.org.example.exception;

public abstract class NotFoundException extends Exception {

    public NotFoundException(String message) {
        super(message);
    }
}
