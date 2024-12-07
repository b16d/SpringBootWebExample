package com.training.web.domain.exception;

public class UserNotException extends RuntimeException{

    public UserNotException(String message) {
        super(message);
    }
}
