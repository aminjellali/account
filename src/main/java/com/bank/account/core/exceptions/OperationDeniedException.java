package com.bank.account.core.exceptions;

/**
 * A business exception thrown depending on the situation but
 * usually when the provided input does not respect certain rules.
 * 
 * like for example negative amounts
 * @author aj
 *
 */
public class OperationDeniedException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public OperationDeniedException(String message) {
		super(message);
	}

}
