package com.bank.account.core.ports.persistence;

import java.util.Optional;

import com.bank.account.core.models.Account;

public interface AccountPersistancePort {
	
	Optional<Account> getAccountById(int id);
	
	Account perisitAccount(Account account);

}
