package de.sbo.financeplanner.domain.account;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public class Address {
    
    @Getter
    private String street;
    @Getter
    private String houseNumber;
    @Getter
    private String city;
    @Getter
    private String country;
    @Getter
    private String postcode;
}
