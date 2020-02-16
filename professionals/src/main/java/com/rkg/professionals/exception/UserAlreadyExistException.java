package com.rkg.professionals.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.PRECONDITION_FAILED, reason="User already exist")
public class UserAlreadyExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public UserAlreadyExistException(String message) {
		super(message);
	}

}
