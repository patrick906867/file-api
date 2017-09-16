package com.example.rest.webservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FileNotExistException extends RuntimeException {

	public FileNotExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
