package com.example.studenmanagewithnuxtjsandspring.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
