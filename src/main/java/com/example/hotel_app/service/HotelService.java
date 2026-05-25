package com.example.hotel_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel_app.model.Hotel;
import com.example.hotel_app.model.Room;
import com.example.hotel_app.repository.HotelRepository;

@Service
public class HotelService {

	
	@Autowired
	private HotelRepository  hotelRepository;
	
	
	public Hotel addHotelWithRooms(Hotel incomingHotelJSONData) {
		
		for(Room r : incomingHotelJSONData.getRooms()) {
			r.setHotel(incomingHotelJSONData);
		}
		
		hotelRepository.save(incomingHotelJSONData);
		return incomingHotelJSONData;
		
	}


	public List<Hotel> getHotelsByLocation(String location) {
		// TODO Auto-generated method stub
		return hotelRepository.readByLocation(location);
	}


	public Integer countHotelsByLocation(String location) {
		// TODO Auto-generated method stub
		return hotelRepository.countByLocation(location);
	}


	public Hotel findHotelByNameAndLocation(String name, String location) {
		// TODO Auto-generated method stub
		return hotelRepository.findByNameAndLocation(name, location);
	}


	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return (List<Hotel>) hotelRepository.findAll();
	}
}
