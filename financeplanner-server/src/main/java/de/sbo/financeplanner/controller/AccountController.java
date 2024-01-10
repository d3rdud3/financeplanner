package de.sbo.financeplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.sbo.financeplanner.domain.account.Account;
import java.util.List;
import de.sbo.financeplanner.domain.account.AccountService;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * Retrieves a list of accounts.
     *
     * @return  a list of Account objects
     */
    @GetMapping("/accounts")
    @ResponseBody
    public List<Account> accounts() {
        return accountService.getAccounts();
    }

    /**
     * Creates a new account.
     *
     * @param  account  the account object to be created
     * @return          the created account object
     */
    @PostMapping("/account")
    @ResponseBody
    public Account createAccount(@RequestBody Account newAccount) {
        return accountService.createAccount(newAccount);
    }


    /**
     * Retrieves an Account object given an account ID.
     *
     * @param  accountId   the ID of the account to retrieve
     * @return             the Account object associated with the given account ID
     */
    @GetMapping("/account")
    @ResponseBody
    public Account getAccount(@RequestParam Long accountId) {
        return accountService.getAccountById(accountId);
    }

    /**
     * Update the account information.
     *
     * @param  updatedAccount  the updated account object
     * @return                 the updated account object
     */
    @PutMapping("/account")
    @ResponseBody
    public Account updateAccount(@RequestParam Account updatedAccount) {
        return accountService.updateAccount(updatedAccount);
    }

}


