package de.sbo.financeplanner.domain.account;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {

    private Long id;

    private String username;

    private LocalDateTime createdOn;

    private LocalDateTime lastLogin;

    private PersonalData personalData;

    private String password;

    private Account(String username, String password, PersonalData personalData){
            this.username = username;
            this.personalData = personalData;
            this.password = password;
            this.lastLogin=null;
            this.createdOn=null;
    }

    public static Account createNew(String username, String password, PersonalData personalData){
        return new Account(username, password, personalData);
    }
}
