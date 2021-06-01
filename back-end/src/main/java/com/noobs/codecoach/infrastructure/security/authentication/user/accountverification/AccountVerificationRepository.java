package com.noobs.codecoach.infrastructure.security.authentication.user.accountverification;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountVerificationRepository extends CrudRepository<AccountVerification, Integer> {
    void deleteAccountVerificationByProfileId(int profileId);

    Optional<AccountVerification> findAccountVerificationByProfileId(int profileId);
}
