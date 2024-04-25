package com.clement.fokuz.exception;

public class UserEmailExistException extends RuntimeException{
    public UserEmailExistException(String message) {
        super(message);
    }
}
