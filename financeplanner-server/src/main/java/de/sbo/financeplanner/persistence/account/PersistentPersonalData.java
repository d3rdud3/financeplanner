package de.sbo.financeplanner.persistence.account;

import java.time.LocalDate;

import de.sbo.financeplanner.domain.account.PersonalData;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class PersistentPersonalData {

    private String firstname;

    private String lastname;

    private LocalDate dateOfBirth;

    private String nationality;

    public PersonalData toDTO() {
        return new PersonalData(this.firstname, this.lastname, this.dateOfBirth, this.nationality);
    }

    public static PersistentPersonalData fromDTO(PersonalData personalData) {
        PersistentPersonalData data = new PersistentPersonalData();
        data.setFirstname(personalData.getFirstname());
        data.setLastname(personalData.getLastname());
        data.setDateOfBirth(personalData.getDateOfBith());
        data.setNationality(personalData.getNationality());
        return data;
    }
}
