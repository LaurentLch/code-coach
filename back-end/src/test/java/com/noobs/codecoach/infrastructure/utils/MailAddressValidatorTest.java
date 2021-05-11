package com.noobs.codecoach.infrastructure.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailAddressValidatorTest {
    @Test
    void givenAWrongMailAddress_assertWrongMailAddress() {
        //given
        String mailAddress = "efzf.com";
        //when

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> MailAddressValidator.assertValidEmailAdress(mailAddress));

    }
    @Test
    void givenAValidMailAddress_assertValidMailAddress() {
        //given
        String mailAddress = "od@dfks.com";
        //when

        //then
        Assertions.assertDoesNotThrow(()->MailAddressValidator.assertValidEmailAdress(mailAddress));

    }

}
