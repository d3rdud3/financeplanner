package de.sbo.financeplanner.domain.account;

import lombok.Value;

@Value
public class AddressDTO {

    private String street;
    private String housenumber;
    private String city;
    private String country;
    private String postcode;
    
}
