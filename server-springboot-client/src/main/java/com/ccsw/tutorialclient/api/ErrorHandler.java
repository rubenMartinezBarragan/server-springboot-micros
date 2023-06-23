package com.ccsw.tutorialclient.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ccsw.tutorialclient.exception.ApplicationError;
import com.ccsw.tutorialclient.exception.ClienteNoExisteException;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ClienteNoExisteException.class)
	public ResponseEntity<ApplicationError> handlerCustomerClienteNoExisteException(ClienteNoExisteException exception,
			WebRequest webRequest) {
		ApplicationError error = new ApplicationError();
		error.setCode(405);
		error.setMessage(exception.getMessage());

		return new ResponseEntity<>(error, HttpStatus.METHOD_NOT_ALLOWED);
	}
}