package com.rkg.professionals.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Subject not found")
public class SubjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public SubjectNotFoundException(String message) {
		super(message);
	}
}
