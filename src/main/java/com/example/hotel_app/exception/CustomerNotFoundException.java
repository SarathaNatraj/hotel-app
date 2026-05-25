package com.example.hotel_app.exception;

public class CustomerNotFoundException extends Exception{
	private String message;

	public CustomerNotFoundException() {
		super();
	}
	public CustomerNotFoundException(String message) {
		super(message);
		this.message=message;
		
	}
}
