package com.noobs.codecoach.infrastructure.security.authentication.user.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String message) {
        super(message);
    }
}
