package com.noobs.codecoach.infrastructure.utils;

import java.util.regex.*;


public class PasswordValidator {
    public static void assertValidPassword(String password) {
        Pattern p = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");
        Matcher m = p.matcher(password);
        boolean b = m.matches();
        if (!b) {
            throw new IllegalArgumentException("Password is invalid");
        }
    }
}
