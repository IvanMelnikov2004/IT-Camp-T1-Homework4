package edu.melnikov.user_auth_service.exception;


public class IncorrectOldPasswordException extends RuntimeException {
    public IncorrectOldPasswordException(String message) {
        super(message);
    }
}

