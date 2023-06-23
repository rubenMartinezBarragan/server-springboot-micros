package com.ccsw.tutorialclient.exception;

public class ClienteNoExisteException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ClienteNoExisteException(String message) {
		super(message);
	}
}