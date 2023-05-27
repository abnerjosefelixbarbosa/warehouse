package com.exemple.backend.exceptions;

import java.io.Serializable;

import lombok.Data;

@Data
public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
}
