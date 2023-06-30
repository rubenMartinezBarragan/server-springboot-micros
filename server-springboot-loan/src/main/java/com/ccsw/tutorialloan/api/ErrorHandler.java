package com.ccsw.tutorialloan.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ccsw.tutorialloan.exception.ApplicationError;
import com.ccsw.tutorialloan.exception.TwoDifferentClientsException;
import com.ccsw.tutorialloan.exception.PreviousEndStartException;
import com.ccsw.tutorialloan.exception.MaximumLoanPeriodException;
import com.ccsw.tutorialloan.exception.LoanTwoGamesException;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(PreviousEndStartException.class)
	public ResponseEntity<ApplicationError> handlerCustomerUnauthorizedException(PreviousEndStartException exception,
			WebRequest webRequest) {
		ApplicationError error = new ApplicationError();
		error.setCode(401);
		error.setMessage(exception.getMessage());

		return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(MaximumLoanPeriodException.class)
	public ResponseEntity<ApplicationError> handlerCustomerForbiddenException(MaximumLoanPeriodException exception,
			WebRequest webRequest) {
		ApplicationError error = new ApplicationError();
		error.setCode(403);
		error.setMessage(exception.getMessage());

		return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(TwoDifferentClientsException.class)
	public ResponseEntity<ApplicationError> handlerCustomerNotFoundException(TwoDifferentClientsException exception,
			WebRequest webRequest) {
		ApplicationError error = new ApplicationError();
		error.setCode(404);
		error.setMessage(exception.getMessage());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(LoanTwoGamesException.class)
	public ResponseEntity<ApplicationError> handlerCustomerConflictException(LoanTwoGamesException exception,
			WebRequest webRequest) {
		ApplicationError error = new ApplicationError();
		error.setCode(409);
		error.setMessage(exception.getMessage());

		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}
}