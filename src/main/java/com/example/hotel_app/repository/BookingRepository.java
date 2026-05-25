package com.example.hotel_app.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.hotel_app.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, Long>{

}
