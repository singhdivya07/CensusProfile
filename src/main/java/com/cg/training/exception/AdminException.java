package com.cg.training.exception;

public class AdminException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String message;

	public AdminException() {
		
	}

	public AdminException(String message) {
		super(message);
		this.message=message;
	}
	
	public AdminException(String message,Exception e) {
		super(message,e);
		this.message=message;
	}

	@Override
	public String toString() {
		return "ProductException [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}
	
	
	
}
