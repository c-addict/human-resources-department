package com.zelenev.exceptions;

public class AccountAlreadyExistsException extends Exception{

    public AccountAlreadyExistsException(String message) {
        super(message);
    }
}
