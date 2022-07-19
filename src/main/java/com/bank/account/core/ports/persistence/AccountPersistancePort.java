package com.bank.account.core.ports.persistence;

import java.util.Optional;

import com.bank.account.core.models.Account;

/**
 * Used to decouple business layer from persistence layer in case
 * persistence to be modified please provide an implementation to this
 * interface.
 * 
 * @author aj
 *
 */
public interface AccountPersistancePort {
	/**
	 * Returns an Optional with account as value from db based on the provided id.
	 * in case no element could be retrieved an Optional.empty()
	 * is expected.
	 * @param id
	 * @return
	 */
	Optional<Account> getAccountById(int id);
	
	/**
	 * Persist an account into the database, supporting
	 * both save and modify operations.
	 * 
	 * @param account
	 * @return
	 */
	Account perisitAccount(Account account);

}
