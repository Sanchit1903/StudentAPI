package com.assignment.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StudentMandatoryParameterMissing extends Exception {
	public StudentMandatoryParameterMissing(String message) {
		super(message);
	}

}
