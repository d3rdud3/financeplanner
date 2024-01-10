package de.sbo.financeplanner.domain.account;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    void createNewAccount() {

        LocalDate now = LocalDate.now();
        LocalDateTime nowWithTime = LocalDateTime.now();
        Account createdAccount = createAccount("testUser", "testUser", "password", "German", "testUser",now, nowWithTime, nowWithTime);
        Assertions.assertTrue(createdAccount != null);
        
        assertAll(
            "Grouped Assertions of created account",
            () -> assertEquals("testUser", createdAccount.getUsername(), "Username should be testUser"),
            () -> assertEquals("password", createdAccount.getPassword(), "Password login should be the same as defined"), 
            () -> assertEquals("testUser", createdAccount.getPersonalData().getFirstname(), "Firstname should be the same as defined"),
            () -> assertEquals("testUser", createdAccount.getPersonalData().getLastname(), "Lastname should be the same as defined"),
            () -> assertEquals("German", createdAccount.getPersonalData().getNationality(), "Nationality login should be the same as defined"),
            () -> assertEquals(now, createdAccount.getPersonalData().getDateOfBith(), "Date of birth should be the same as defined"),
            () -> assertTrue(createdAccount.getId() != null, "ID is set after persistence")
        );
    }

    @Test
    void findAccountById() {
        LocalDate now = LocalDate.now();
        LocalDateTime nowWithTime = LocalDateTime.now();
        Account createdAccount = createAccount("testUser", "testUser", "password", "German", "testUser",now, nowWithTime, nowWithTime);   
        Account foundAccount = accountService.getAccountById(createdAccount.getId());

        assertAll(
            "Grouped Assertions of found account",
            () -> assertEquals("testUser", foundAccount.getUsername(), "Username should be testUser"),
            () -> assertEquals("password", foundAccount.getPassword(), "Password login should be the same as defined"), 
            () -> assertEquals("testUser", foundAccount.getPersonalData().getFirstname(), "Firstname should be the same as defined"),
            () -> assertEquals("testUser", foundAccount.getPersonalData().getLastname(), "Lastname should be the same as defined"),
            () -> assertEquals("German", foundAccount.getPersonalData().getNationality(), "Nationality login should be the same as defined"),
            () -> assertEquals(now, foundAccount.getPersonalData().getDateOfBith(), "Date of birth should be the same as defined"),
            () -> assertTrue(foundAccount.getId() != null, "ID is set after persistence")
        );
    }


    @Test
    void getAllAccounts() {
        LocalDate now = LocalDate.now();
        LocalDateTime nowWithTime = LocalDateTime.now();
        createAccount("testUser", "testUser", "password", "German", "testUser",now, nowWithTime, nowWithTime);   
        createAccount("testUser", "testUser", "password", "German", "testUser2",now, nowWithTime, nowWithTime);
        createAccount("testUser", "testUser", "password", "German", "testUser3",now, nowWithTime, nowWithTime);   
        Assertions.assertEquals(3, accountService.getAccounts().size());  
    }


    private Account createAccount(String firstName, String lastName, String password, String nationality, String username, LocalDate dateOfBirth, LocalDateTime createdOn, LocalDateTime lastLogin) {
        PersonalData personalData = new PersonalData(firstName, lastName, dateOfBirth, nationality);
        Account accountToCreate = new Account(null, username, createdOn, lastLogin, personalData,password);
        return accountService.createAccount(accountToCreate);
    }

    

}
