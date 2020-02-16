package com.rkg.professionals.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.PRECONDITION_REQUIRED, reason="Skill already exist")
public class SkillAlreadyExistException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public SkillAlreadyExistException(String message) {
		super(message);
	}

}
