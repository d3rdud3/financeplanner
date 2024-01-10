package de.sbo.financeplanner.domain.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressTest {

    @Test
    void testCreateAddress(){
        Address address = new Address("demo", "2b", "anytown", "germany", "12345");
        Assertions.assertNotNull(address);
    }



}
