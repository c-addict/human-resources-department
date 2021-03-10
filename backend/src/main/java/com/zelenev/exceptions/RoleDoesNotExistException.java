package com.zelenev.exceptions;

public class RoleDoesNotExistException extends RuntimeException {

    public RoleDoesNotExistException(String message) {
        super(message);
    }
}
