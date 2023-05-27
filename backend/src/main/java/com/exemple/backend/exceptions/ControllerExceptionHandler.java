package com.exemple.backend.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@RestControllerAdvice
public class ControllerExceptionHandler {
	@ExceptionHandler(EntityBadRequestException.class)
	public ResponseEntity<StandardError> entityBadRequest(EntityBadRequestException e, HttpServletRequest request) {
		StandardError error = new StandardError();
		error.setTimestamp(Instant.now().toString());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setError("Bad request");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<StandardError> entityBadRequest(IllegalArgumentException e, HttpServletRequest request) {
		StandardError error = new StandardError();
		error.setTimestamp(Instant.now().toString());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setError("Bad request");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<StandardError> entityBadRequest(InvalidFormatException e, HttpServletRequest request) {
		StandardError error = new StandardError();
		error.setTimestamp(Instant.now().toString());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setError("Bad request");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<StandardError> entityBadRequest(EntityNotFoundException e, HttpServletRequest request) {
		StandardError error = new StandardError();
		error.setTimestamp(Instant.now().toString());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setError("Not found");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
