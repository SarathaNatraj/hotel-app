package com.example.hotel_app.dto;

import java.time.LocalDate;

public class BookingDTO {
	
	 private Long bookingId;

	    private LocalDate checkIn;
	    private LocalDate checkOut;
	    
	    public BookingDTO() {
	    	
	    }

		public Long getBookingId() {
			return bookingId;
		}

		public void setBookingId(Long bookingId) {
			this.bookingId = bookingId;
		}

		public LocalDate getCheckIn() {
			return checkIn;
		}

		public void setCheckIn(LocalDate checkIn) {
			this.checkIn = checkIn;
		}

		public LocalDate getCheckOut() {
			return checkOut;
		}

		public void setCheckOut(LocalDate checkOut) {
			this.checkOut = checkOut;
		}

		public BookingDTO(Long bookingId, LocalDate checkIn, LocalDate checkOut) {
			super();
			this.bookingId = bookingId;
			this.checkIn = checkIn;
			this.checkOut = checkOut;
		}
	    


}
