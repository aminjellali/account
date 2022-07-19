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
	 * Allows you to deposit money to a provided account.
	 * 
	 * @param accountId the account to modify.
	 * @param ammount   the ammount to add to the account
	 * @throws OperationDeniedException          when ammount is null or values is negative
	 *                                  or zero.
	 * @throws AccountNotFoundException when the provided account wasn't found.
	 */
	Account depositMoneyToAccount(int accountId, Double ammount) throws OperationDeniedException, AccountNotFoundException;

	/**
	 * 
	 * @param accountId
	 * @param ammount
	 * @throws OperationDeniedException
	 * @throws AccountNotFoundException
	 */
	Account withdrawMoneyMoneyToAccount(int accountId, Double ammount) throws OperationDeniedException, AccountNotFoundException;

	/**
	 * Init an account with 0 amount and save it.
	 * 
	 * @param userName
	 * @return
	 */
	void intAccount(String userName);
	
	AccountHistory getHistory(Integer id) throws AccountNotFoundException;

}
