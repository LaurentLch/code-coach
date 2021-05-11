package com.noobs.codecoach.infrastructure.utils;

import org.apache.commons.validator.routines.EmailValidator;

public final class MailAddressValidator {
    public static void assertValidEmailAdress(String emailAdress) {
        if (emailAdress == null) {
            throw new IllegalArgumentException("Email adress is null");
        }
        if (!EmailValidator.getInstance().isValid(emailAdress)) {
            throw new IllegalArgumentException("Email address is invalid");
        }
    }
}
