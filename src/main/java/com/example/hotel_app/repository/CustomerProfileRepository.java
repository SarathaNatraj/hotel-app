package com.example.hotel_app.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.hotel_app.model.CustomerProfile;

public interface CustomerProfileRepository  extends CrudRepository<CustomerProfile, Long>{

}
