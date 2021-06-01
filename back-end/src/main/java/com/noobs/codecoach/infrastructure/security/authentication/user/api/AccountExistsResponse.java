package com.noobs.codecoach.infrastructure.security.authentication.user.api;

public class AccountExistsResponse {

    private boolean existsByEmail;

    public AccountExistsResponse(boolean existsByEmail) {
        this.existsByEmail = existsByEmail;
    }

    public boolean isExistsByEmail() {
        return existsByEmail;
    }
}
