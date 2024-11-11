package com.bank.banking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class InsufficientFundException extends RuntimeException{
	
	 public InsufficientFundException() {
	        super();
	    }

	    public InsufficientFundException(String message) {
	        super(message);
	    }

}
