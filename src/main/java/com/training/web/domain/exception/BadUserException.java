package com.training.web.domain.exception;

public class BadUserException extends RuntimeException{

    public BadUserException(String message) {
        super(message);
    }
}
