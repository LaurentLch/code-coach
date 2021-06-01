package com.noobs.codecoach.infrastructure.security.authentication.user.event;

import com.noobs.codecoach.domain.Event;
import com.noobs.codecoach.infrastructure.security.authentication.user.accountverification.AccountVerification;
import com.noobs.codecoach.infrastructure.security.authentication.user.api.Account;

public class AccountCreated implements Event {

    private final Account account;
    private final AccountVerification accountVerification;

    public AccountCreated(Account account, AccountVerification accountVerification) {
        this.account = account;
        this.accountVerification = accountVerification;
    }

    public Account getAccount() {
        return account;
    }

    public int getProfileId() {
        return accountVerification.getId();
    }

    public String getVerificationCode() {
        return accountVerification.getVerificationCode();
    }
}
