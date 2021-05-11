package com.noobs.codecoach.infrastructure.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void givenAWrongPassword_assertWrongPassword() {
        //given
        String password = "1";
        //when

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> PasswordValidator.assertValidPassword(password));

    }
    @Test
    void givenAValidPassword_assertValidPassword() {
        //given
        String password = "A1oddfks";
        //when

        //then
        Assertions.assertDoesNotThrow(()->PasswordValidator.assertValidPassword(password));

    }


}
