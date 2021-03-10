package com.zelenev.exceptions;

public class CardDoesNotExistsException extends RuntimeException{

    public CardDoesNotExistsException(String message) {
        super(message);
    }
}
