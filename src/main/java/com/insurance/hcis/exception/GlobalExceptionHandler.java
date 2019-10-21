package com.insurance.hcis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 * 
 *Description- This class is used as a global handler to handle the errors globally.
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidPolicyException.class)
	public ResponseEntity<ErrorResponse> globalExceptionHandler(InvalidPolicyException exception) {

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.OK);
	}
}
