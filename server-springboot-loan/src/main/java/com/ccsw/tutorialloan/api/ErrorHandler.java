package com.ccsw.tutorialloan.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ccsw.tutorialloan.exception.ApplicationError;
import com.ccsw.tutorialloan.exception.DosClientesDistintosException;
import com.ccsw.tutorialloan.exception.FinAnteriorInicioException;
import com.ccsw.tutorialloan.exception.PeriodoPrestamoMaximoException;
import com.ccsw.tutorialloan.exception.PrestadosDosJuegosException;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(FinAnteriorInicioException.class)
	public ResponseEntity<ApplicationError> handlerCustomerUnauthorizedException(FinAnteriorInicioException exception,
			WebRequest webRequest) {
		ApplicationError error = new ApplicationError();
		error.setCode(401);
		error.setMessage(exception.getMessage());

		return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(PeriodoPrestamoMaximoException.class)
	public ResponseEntity<ApplicationError> handlerCustomerForbiddenException(PeriodoPrestamoMaximoException exception,
			WebRequest webRequest) {
		ApplicationError error = new ApplicationError();
		error.setCode(403);
		error.setMessage(exception.getMessage());

		return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(DosClientesDistintosException.class)
	public ResponseEntity<ApplicationError> handlerCustomerNotFoundException(DosClientesDistintosException exception,
			WebRequest webRequest) {
		ApplicationError error = new ApplicationError();
		error.setCode(404);
		error.setMessage(exception.getMessage());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PrestadosDosJuegosException.class)
	public ResponseEntity<ApplicationError> handlerCustomerConflictException(PrestadosDosJuegosException exception,
			WebRequest webRequest) {
		ApplicationError error = new ApplicationError();
		error.setCode(409);
		error.setMessage(exception.getMessage());

		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}
}