package com.example.hotel_app.exception;

public class RoomNotFoundException  extends Exception{
	private String message;

	public RoomNotFoundException() {
		super();
	}
	public RoomNotFoundException(String message) {
		super(message);
		this.message=message;
		
	}

}
