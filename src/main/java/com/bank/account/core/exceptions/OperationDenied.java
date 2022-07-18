package com.bank.account.core.exceptions;

public class OperationDenied extends Exception {
	
	private static final long serialVersionUID = 1L;

	public OperationDenied(String message) {
		super(message);
	}

}
