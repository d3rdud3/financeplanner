package de.sbo.financeplanner.domain.account.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import de.sbo.financeplanner.domain.account.Account;
import de.sbo.financeplanner.domain.account.AccountService;
import de.sbo.financeplanner.domain.account.PersonalData;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AccountControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private AccountService accountService;

    @Test
    void accountsShouldReturnAllAvailableAccounts() throws Exception {

        LocalDate now = LocalDate.now();
        LocalDateTime nowWithTime = LocalDateTime.now();

        PersonalData personalData = new PersonalData("testname1", "testLastname1", now, "german");

        accountService.createAccount(
                new Account(null, "testUser1", nowWithTime, nowWithTime, personalData,
                        "testPassword1"));

        ResponseEntity<Account[]> response = this.restTemplate.getForEntity("http://localhost:" + port + "/accounts",
                Account[].class);

        Assertions.assertEquals(1, response.getBody().length);
        Account createdAccount = response.getBody()[0];

        assertAll(
            "Grouped Assertions of created account",
            () -> assertEquals("testUser1", createdAccount.getUsername(), "Username should be testUser"),
            () -> assertEquals("testPassword1", createdAccount.getPassword(), "Password login should be the same as defined"), 
            () -> assertEquals("testname1", createdAccount.getPersonalData().getFirstname(), "Firstname should be the same as defined"),
            () -> assertEquals("testLastname1", createdAccount.getPersonalData().getLastname(), "Lastname should be the same as defined"),
            () -> assertEquals("german", createdAccount.getPersonalData().getNationality(), "Nationality login should be the same as defined"),
            () -> assertEquals(now, createdAccount.getPersonalData().getDateOfBith(), "Date of birth should be the same as defined"),
            () -> assertTrue(createdAccount.getId() != null, "ID is set after persistence")
        );
    }
}


