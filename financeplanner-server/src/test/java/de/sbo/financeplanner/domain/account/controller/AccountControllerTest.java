package de.sbo.financeplanner.domain.account.controller;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import de.sbo.financeplanner.controller.AccountController;

@SpringBootTest
public class AccountControllerTest {


    @Autowired
	private AccountController controller;

	@Test
	void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
	}

    
}
