package com.bank.account.core.ports.buisness;

import com.bank.account.core.exceptions.AccountNotFoundException;
import com.bank.account.core.exceptions.OperationDeniedException;
import com.bank.account.core.models.Account;

/**
 * An port interface used to interact with an account object.
 * 
 * @author aj
 *
 */
public interface ManageAccount {
	/**
	 * Allows user to deposit money to a provided account and update linked
	 * operations.
	 * 
	 * @param accountId the account to modify.
	 * @param amount    the amount to add to the account
	 * @throws OperationDeniedException when ammount is null or values is negative
	 *                                  or zero.
	 * @throws AccountNotFoundException when the provided account wasn't found in
	 *                                  the persistence layer.
	 */
	Account depositMoneyToAccount(int accountId, Double amount)
			throws OperationDeniedException, AccountNotFoundException;

	/**
	 * Allows user to withdraw money and update operations on a given account.
	 * 
	 * @param accountId the account id to withdraw money from.
	 * @param amount    the value to withdraw from account (not null and not
	 *                  negative)
	 * @throws OperationDeniedException in case amount is null or less or equal to
	 *                                  zero, or larger then balance.
	 * @throws AccountNotFoundException in case account not found.
	 */
	Account withdrawMoneyMoneyToAccount(int accountId, Double amount)
			throws OperationDeniedException, AccountNotFoundException;

	/**
	 * Init an account with 0 amount and save it.
	 * 
	 * @param userName
	 * @return
	 */
	void intAccount(String userName);

	/**
	 * Retreive account history information.
	 * 
	 * @param id
	 * @return
	 * @throws AccountNotFoundException
	 */
	AccountHistory getHistory(Integer id) throws AccountNotFoundException;

}
