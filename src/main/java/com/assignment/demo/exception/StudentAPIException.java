package com.assignment.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class StudentAPIException extends Exception {

	public StudentAPIException(String message) {
		super(message);
	}
}
