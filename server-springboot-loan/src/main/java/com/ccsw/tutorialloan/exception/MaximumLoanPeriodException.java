package com.ccsw.tutorialloan.exception;

public class MaximumLoanPeriodException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MaximumLoanPeriodException(String message) {
		super(message);
	}
}