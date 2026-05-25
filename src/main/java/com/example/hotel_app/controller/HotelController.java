package com.example.hotel_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel_app.model.Hotel;
import com.example.hotel_app.service.HotelService;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@PostMapping
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel incomingHotelJSONData) {
		Hotel savedHotel = hotelService.addHotelWithRooms(incomingHotelJSONData);
		return new ResponseEntity<Hotel>(savedHotel, HttpStatus.OK);
	}
	 @GetMapping
	    public List<Hotel> getAllHotels() {
	        return hotelService.getAllHotels();
	    }
	@GetMapping("/byCity/{location}")
	public ResponseEntity<List<Hotel>> getHotelsByLocation(@PathVariable String location){
		List<Hotel> hotelsList = hotelService.getHotelsByLocation(location);
		return new ResponseEntity<List<Hotel>>(hotelsList, HttpStatus.OK);
	}
	
	@GetMapping("/byCityCount/{location}")
	public ResponseEntity<Integer> countHotelsByLocation(@PathVariable String location){
		Integer hotelsCount = hotelService.countHotelsByLocation(location);
		return new ResponseEntity<Integer>(hotelsCount, HttpStatus.OK);
	}
	@GetMapping("/byNameAndCity")
	public ResponseEntity<Hotel> findHotelByNameAndLocation(@RequestParam String name,@RequestParam String location){
		Hotel fetchedHotel = hotelService.findHotelByNameAndLocation(name,location);
		return new ResponseEntity<Hotel>(fetchedHotel, HttpStatus.OK);
	}
}
