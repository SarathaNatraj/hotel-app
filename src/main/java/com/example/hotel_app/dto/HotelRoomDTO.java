package com.example.hotel_app.dto;

import java.math.BigDecimal;

public record HotelRoomDTO(Long hotelId, String name,String location,Long roomId,  String roomNumber,  String type, BigDecimal price) {

}
