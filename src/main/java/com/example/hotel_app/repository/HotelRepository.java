package com.example.hotel_app.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.hotel_app.model.Hotel;
import java.util.*;

public interface HotelRepository  extends CrudRepository<Hotel, Long>{

	
	public List<Hotel> readByLocation(String location);
	
	public Integer countByLocation(String location);
	
	
	//select * from hotel where name=:name and location=:location
	public Hotel findByNameAndLocation(String name, String location);
}
