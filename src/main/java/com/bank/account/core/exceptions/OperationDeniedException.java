package com.bank.account.core.exceptions;

public class OperationDeniedException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public OperationDeniedException(String message) {
		super(message);
	}

}
