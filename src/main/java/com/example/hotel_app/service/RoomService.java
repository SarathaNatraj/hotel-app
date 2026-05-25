package com.example.hotel_app.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.hotel_app.exception.CustomerNotFoundException;
import com.example.hotel_app.exception.RoomNotFoundException;
import com.example.hotel_app.model.Booking;
import com.example.hotel_app.model.Customer;
import com.example.hotel_app.model.Room;
import com.example.hotel_app.repository.RoomRepository;

@Service
public class RoomService {
	
	@Autowired
	private RoomRepository roomRepository;
	
	public Room addRooms(Room incomingJSONData) {
		
		for(Booking b : incomingJSONData.getBookings()) {
			b.setRoom(incomingJSONData);
		}
		
		return roomRepository.save(incomingJSONData);
		
	}

	public Room getRoomById(Long id) throws RoomNotFoundException {
		// TODO Auto-generated method stub
		Room result = roomRepository.findById(id)
			    .orElseThrow(() -> new RoomNotFoundException("Room not found with id: " + id));
//		if()
		return result;
	}

	public List<Room> getRoomsLessThanPrice(BigDecimal price) {
		// TODO Auto-generated method stub
		return roomRepository.priceLessThan(price);
	}

	public List<Room> getRoomsWithBookings() {
		// TODO Auto-generated method stub
		return roomRepository.findAllRoomsWithBookings();
	}

	public List<Room> getAvailableRooms(LocalDate date) {
		// TODO Auto-generated method stub
		return roomRepository.findAvailableRoomsUsingQuery(date);
	}

	public List<Room> getAllRooms() {
		// TODO Auto-generated method stub
		return roomRepository.findAll();
	}

}
