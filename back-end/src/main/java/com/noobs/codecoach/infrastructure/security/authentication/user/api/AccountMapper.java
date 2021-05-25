package com.noobs.codecoach.infrastructure.security.authentication.user.api;

import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public SecuredUserDto toUserDto(Account account) {
        return new SecuredUserDto(account.getId(), account.getEmail(), account.isAccountEnabled());
    }
}
