package de.sbo.financeplanner.domain.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import de.sbo.financeplanner.persistence.account.AccountRepository;
import de.sbo.financeplanner.persistence.account.PersistentAccount;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAccounts() {
        return accountRepository
                .findAll()
                .stream()
                .map(account -> account.toDTO())
                .collect(Collectors.toList());
    }

    public Account createAccount(Account account) {
           PersistentAccount createdAccount = accountRepository.save(PersistentAccount.fromDTO(account));
           return createdAccount.toDTO();
    }

    public Account getAccountById(Long accountId) {
        Optional<PersistentAccount> optionalAccount = accountRepository.findById(accountId);
        return optionalAccount.map(PersistentAccount::toDTO).orElse(null);
    }

    public Account updateAccount(Account updatedAccount) {
        PersistentAccount persistentAccount = PersistentAccount.fromDTO(updatedAccount);
        PersistentAccount updatedPersistentAccount = accountRepository.save(persistentAccount);
        return updatedPersistentAccount.toDTO();
    }  
}
