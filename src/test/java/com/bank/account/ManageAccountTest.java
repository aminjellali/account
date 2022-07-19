package com.bank.account;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.lenient;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Description;

import com.bank.account.core.exceptions.AccountNotFoundException;
import com.bank.account.core.exceptions.OperationDeniedException;
import com.bank.account.core.models.Account;
import com.bank.account.core.models.Operation;
import com.bank.account.core.models.OperationTypeEnum;
import com.bank.account.core.ports.buisness.ManageAccount;
import com.bank.account.core.ports.buisness.ManageAccountImpl;
import com.bank.account.core.ports.persistence.AccountPersistancePort;
import com.bank.account.persistance_adapter.AccountEntityRepository;

@ExtendWith(MockitoExtension.class)
public class ManageAccountTest {
	
	@Mock
	AccountEntityRepository repo;
	
	@Mock
	private AccountPersistancePort persistencePort;
	
	ManageAccount manageAccount; 

	@BeforeEach
	public void init() {
		this.manageAccount = new ManageAccountImpl(persistencePort);
		Optional<Account> validAccount = Optional.of(Account.builder().userName("Name").operations(new ArrayList<Operation>()).balanace(10.0).build());

		lenient().when(persistencePort.getAccountById(0)).thenReturn(validAccount);
		lenient().when(persistencePort.getAccountById(-1)).thenReturn(Optional.empty());
	}
	
	@Test
	@Description("Should assert to true adding 10$ to the accont.")
	public void depositValidTest() throws OperationDeniedException, AccountNotFoundException{
		Account toSAve = Account.builder().userName("Name").operations(new ArrayList<Operation>()).balanace(10.0).build();
		toSAve.setBalanace(20.0);
		toSAve.getOperations().add(Operation.builder().impactOnAccount(10.0).operationType(OperationTypeEnum.DEPOSIT).build());
		

		lenient().when(persistencePort.perisitAccount(Mockito.any(Account.class))).thenReturn(toSAve);
		
		Account account = manageAccount.depositMoneyToAccount(0, 10.0);
		
		assertEquals(account.getBalanace(), 20.0,0);
		assertEquals(account.getOperations().size(), 1);
	}
	
	@Test
	@Description("Should throw exception as account does not exist.")
	public void depositInValidTest1AccountNotFound() throws OperationDeniedException, AccountNotFoundException{
		assertThatExceptionOfType(AccountNotFoundException.class)
		.isThrownBy(() -> manageAccount.depositMoneyToAccount(-1, 10.0));
	}
	
	@Test
	@Description("Should throw exception as amount not valid.")
	public void depositInValidTestAmountNotValid() throws OperationDeniedException, AccountNotFoundException{
		assertThatExceptionOfType(OperationDeniedException.class)
		.isThrownBy(() -> manageAccount.depositMoneyToAccount(0, -10.0));
	}
	
	@Test
	@Description("Should assert to true whithdrawing 10$ from the accont.")
	public void withdrawValidTest() throws OperationDeniedException, AccountNotFoundException{
		Account toSAve = Account.builder().userName("Name").operations(new ArrayList<Operation>()).balanace(10.0).build();
		toSAve.setBalanace(0.0);
		toSAve.getOperations().add(Operation.builder().impactOnAccount(10.0).operationType(OperationTypeEnum.WITHDRAW).build());
		

		lenient().when(persistencePort.perisitAccount(Mockito.any(Account.class))).thenReturn(toSAve);
		
		Account account = manageAccount.depositMoneyToAccount(0, 10.0);
		
		assertEquals(account.getBalanace(), 00.0,0);
		assertEquals(account.getOperations().size(), 1);
	}
	@Test
	@Description("Should throw exception as account does not exist.")
	public void withdrawInValidTesAsAccountNotfound() throws OperationDeniedException, AccountNotFoundException {
		assertThatExceptionOfType(AccountNotFoundException.class)
		.isThrownBy(() -> manageAccount.withdrawMoneyMoneyToAccount(-1, 10.0));
	}
	@Test
	@Description("Should throw exception as amount not valid.")
	public void withdrawInValidTestAmountNotValid() throws OperationDeniedException, AccountNotFoundException {
		assertThatExceptionOfType(OperationDeniedException.class)
		.isThrownBy(() -> manageAccount.withdrawMoneyMoneyToAccount(0, -10.0));
	}	
	

	@Test
	@Description("Should throw exception as balance not enough.")
	public void withdrawInValidTestBalanceNotEnough() throws OperationDeniedException, AccountNotFoundException {
		assertThatExceptionOfType(OperationDeniedException.class)
		.isThrownBy(() -> manageAccount.withdrawMoneyMoneyToAccount(0, 100.0));
	}	

}
