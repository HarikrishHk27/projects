package com.example.demo.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerException {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<CustomerFieldError>> exceptionHandler(MethodArgumentNotValidException e) {

	List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
	List<CustomerFieldError> fieldErrorMessages = fieldErrors.stream().map(fieldError-> new CustomerFieldError(fieldError.getField(),fieldError.getDefaultMessage())).collect(Collectors.toList());
	return new ResponseEntity<List<CustomerFieldError>>(fieldErrorMessages, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> customerIdException(CustomerNotFoundException e)
	{
		return new ResponseEntity<>("CustomerId not found",HttpStatus.BAD_REQUEST);
	}
	

}
