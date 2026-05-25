package com.example.hotel_app.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel_app.dto.RoomBookingDTO;
import com.example.hotel_app.exception.CustomerNotFoundException;
import com.example.hotel_app.exception.RoomNotFoundException;
import com.example.hotel_app.model.Customer;
import com.example.hotel_app.model.Hotel;
import com.example.hotel_app.model.Room;
import com.example.hotel_app.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

	
	@Autowired
	private RoomService roomService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Room>> getAllRooms(){
		List<Room> roomsList=roomService.getAllRooms();
		return ResponseEntity.ok(roomsList);
	}
	@PostMapping
	public ResponseEntity<Room> addRoomWithBookings(@RequestBody RoomBookingDTO roomIncomingJSONDTO){
		
		Room roomIncomingJSONData = new Room();
		roomIncomingJSONData.setPrice(roomIncomingJSONDTO.getPrice());
		roomIncomingJSONData.setRoomNumber(roomIncomingJSONDTO.getRoomNumber());
		roomIncomingJSONDTO.setType(roomIncomingJSONDTO.getType());
		Room savedRoom = roomService.addRooms(roomIncomingJSONData);
		
		//RoomBookingReponseDTO
		return new ResponseEntity<Room>(savedRoom, HttpStatusCode.valueOf(200));
		//return ResponseEntity.created(savedRoom);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getRoomById(@PathVariable Long id) throws RoomNotFoundException{
		
		Room room = roomService.getRoomById(id);
		if(room != null)
			return new ResponseEntity<Room>(room, HttpStatusCode.valueOf(200));
		else
			return new ResponseEntity<>("Room not Found : "+id, HttpStatusCode.valueOf(404));
	}
	
	@GetMapping("/byPriceLess/{price}")
	public ResponseEntity<List<Room>> getRoomsLessThanPrice(@PathVariable BigDecimal price){
		List<Room> roomsList = roomService.getRoomsLessThanPrice(price);
		return new ResponseEntity<List<Room>>(roomsList, HttpStatus.OK);
	}
	

	@GetMapping("/byRoomsWithBookings")
	public ResponseEntity<List<Room>> getRoomsWithBookings(){
		List<Room> roomsList = roomService.getRoomsWithBookings();
		return new ResponseEntity<List<Room>>(roomsList, HttpStatus.OK);
	}
	@GetMapping("/available")
    public ResponseEntity<List<Room>> getAvailableRooms(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Room> availableRooms = roomService.getAvailableRooms(date);
        return ResponseEntity.ok(availableRooms);
    }

}
