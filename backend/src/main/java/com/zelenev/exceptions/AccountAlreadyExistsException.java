package com.zelenev.exceptions;

public class AccountAlreadyExistsException extends RuntimeException{

    public AccountAlreadyExistsException(String message) {
        super(message);
    }
}
