package com.bank.account.core.exceptions;

/**
 * A buisness exception thrown when ever a searched account is not to be found.
 * 
 * @author aj
 *
 */
public class AccountNotFoundException extends Exception {

	private static final long serialVersionUID = 10L;

	public AccountNotFoundException(String message) {
		super(message);
	}
}
