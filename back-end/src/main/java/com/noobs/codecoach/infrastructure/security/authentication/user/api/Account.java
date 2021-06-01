package com.noobs.codecoach.infrastructure.security.authentication.user.api;

import com.noobs.codecoach.infrastructure.security.authentication.user.Authority;

import java.util.List;

public interface Account {
    int getId();

    String getEmail();

    String getPassword();
    void setPassword(String encode);

    List<Authority> getAuthorities();

    boolean isAccountEnabled();
    void enableAccount();
}
