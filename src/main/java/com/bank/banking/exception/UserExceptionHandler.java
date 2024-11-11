package com.bank.banking.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseBody
	public ResponseEntity<GlobalErrorType> userNotFoundExceptionHandler(UserNotFoundException userNotFoundExp) {
		return new ResponseEntity<GlobalErrorType>(
				new GlobalErrorType(userNotFoundExp.getMessage(), "USER_NOT_FOUND"), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	public ResponseEntity<GlobalErrorType> duplicateUserExceptionHandler(ConstraintViolationException duplicateUsrEx) {

		return new ResponseEntity<GlobalErrorType>(new GlobalErrorType("User already exist", "DUPLICATE_DATA"),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InsufficientFundException.class)
	@ResponseBody
	public ResponseEntity<GlobalErrorType> insufficientFundExceptionHandler(InsufficientFundException insuffcFund) {

		return new ResponseEntity<GlobalErrorType>(new GlobalErrorType(insuffcFund.getMessage(), "INSUFFICIENT_FUND"),
				HttpStatus.BAD_REQUEST);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException exception) {

		Map<String, Object> errors = new LinkedHashMap<>();
		exception.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseBody
	public ResponseEntity<GlobalErrorType> NotFoundExceptionHandler(NotFoundException NotFoundExp) {
		return new ResponseEntity<GlobalErrorType>(
				new GlobalErrorType(NotFoundExp.getMessage(), "NOT_FOUND"), HttpStatus.NOT_FOUND);
	}
}
