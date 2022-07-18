package com.bank.account;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bank.account.core.ports.persistence.AccountPersistancePort;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManageAccountTest {
	
	@MockBean
	private AccountPersistancePort persistencePort;
	
	@Test
	public void depositValidTest() {
		
	}
	@Test
	public void depositInValidTest() {
		
	}
	
	@Test
	public void withdrawValidTest() {
		
	}
	@Test
	public void withdrawInValidTest() {
		
	}
	

}
