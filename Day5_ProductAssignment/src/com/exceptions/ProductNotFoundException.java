package com.exceptions;

public class ProductNotFoundException extends Exception{
 
	private String message;
	
	public ProductNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public ProductNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
