package de.sbo.financeplanner.persistence.account;

import java.time.LocalDateTime;

import org.hibernate.envers.Audited;

import de.sbo.financeplanner.domain.account.Account;
import de.sbo.financeplanner.domain.account.PersonalData;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Account")
@Audited
@Getter
@Setter
public class PersistentAccount {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private PersistentPersonalData personalData;

    private LocalDateTime createdOn;

    private LocalDateTime lastLogin;

    private String password;

    @Column(unique=true)
    private String username;

    public Account toDTO() {
        return new Account(this.id, this.username, this.createdOn, this.lastLogin, this.personalData.toDTO(),
                this.password);
    }

    public static PersistentAccount fromDTO(Account account) {
        PersistentAccount persistentAccount = new PersistentAccount();
        persistentAccount.setUsername(account.getUsername());
        persistentAccount.setPassword(account.getPassword());
        persistentAccount.setCreatedOn(account.getCreatedOn());
        persistentAccount.setLastLogin(account.getLastLogin());
        persistentAccount.setPersonalData(PersistentPersonalData.fromDTO(account.getPersonalData()));
        return persistentAccount;
    }
}
