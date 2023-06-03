package com.exemple.backend.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandle {
	@ExceptionHandler(EntityBadRequestException.class)
	public ResponseEntity<HandleError> entityBadRequest(EntityBadRequestException e, HttpServletRequest request) {
		HandleError error = new HandleError();
		error.setTimestamp(Instant.now().toString());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setError("Bad request");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<HandleError> entityNotFound(EntityNotFoundException e, HttpServletRequest request) {
		HandleError error = new HandleError();
		error.setTimestamp(Instant.now().toString());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setError("Not found");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<HandleError> entityBadRequest(Exception e, HttpServletRequest request) {
		HandleError error = new HandleError();
		error.setTimestamp(Instant.now().toString());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setError("Bad request");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
