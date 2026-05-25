package com.example.hotel_app.dto;

import java.math.BigDecimal;
import java.util.*;

public class RoomBookingDTO {

	
	private Long roomId;
    private String roomNumber;
    private String type;  // e.g., Single, Double, Suite
    private BigDecimal price;
    private List<BookingDTO> bookings;
    public RoomBookingDTO() {
    	
    }
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public List<BookingDTO> getBookings() {
		return bookings;
	}
	public void setBookings(List<BookingDTO> bookings) {
		this.bookings = bookings;
	}
   

}
