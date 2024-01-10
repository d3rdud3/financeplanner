package de.sbo.financeplanner.domain.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDateTime;

import de.sbo.financeplanner.persistence.account.AccountRepository;
import de.sbo.financeplanner.persistence.account.PersistentAccount;

@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository repository;

    @Test
    void initialRevision() {
        PersistentAccount account = new PersistentAccount();
        account.setCreatedOn(LocalDateTime.now());
        account.setLastLogin(LocalDateTime.now());
        account.setPassword("password");
        account.setUsername("testUser");
        account.setPersonalData(null);
        account = repository.save(account);
        PersistentAccount loaded = repository.findById(account.getId()).get();
        Assertions.assertNotNull(loaded);
    }
}