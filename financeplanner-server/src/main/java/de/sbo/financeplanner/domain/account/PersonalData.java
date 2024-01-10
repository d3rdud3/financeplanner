package de.sbo.financeplanner.domain.account;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PersonalData {

    private String firstname;

    private String lastname;

    private LocalDate dateOfBith;

    private String nationality;

}
