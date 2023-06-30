package com.ccsw.tutorialloan.exception;

public class TwoDifferentClientsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TwoDifferentClientsException(String message) {
		super(message);
	}
}