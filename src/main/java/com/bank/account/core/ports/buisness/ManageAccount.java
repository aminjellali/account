package com.bank.account.core.ports.buisness;

import com.bank.account.core.exceptions.AccountNotFoundException;
import com.bank.account.core.exceptions.OperationDenied;

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
	 * @throws OperationDenied          when ammount is null or values is negative
	 *                                  or zero.
	 * @throws AccountNotFoundException when the provided account wasn't found.
	 */
	void depositMoneyToAccount(int accountId, Double ammount) throws OperationDenied, AccountNotFoundException;

	/**
	 * 
	 * @param accountId
	 * @param ammount
	 * @throws OperationDenied
	 * @throws AccountNotFoundException
	 */
	void withdrawMoneyMoneyToAccount(int accountId, Double ammount) throws OperationDenied, AccountNotFoundException;

	/**
	 * Init an account with 0 amount and save it.
	 * 
	 * @param userName
	 * @return
	 */
	void intAccount(String userName);
	
	AccountHistory getHistory(Integer id) throws AccountNotFoundException;

}
