package com.mecflow.restapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mecflow.restapi.exception.DuplicateCodValueException;
import com.mecflow.restapi.exception.RecordNotFoundException;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	@ExceptionHandler(RecordNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleNotFoundException(RecordNotFoundException ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(DuplicateCodValueException.class)
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	public String handleDuplicateException(DuplicateCodValueException ex) {
		return ex.getMessage();
	}
}
