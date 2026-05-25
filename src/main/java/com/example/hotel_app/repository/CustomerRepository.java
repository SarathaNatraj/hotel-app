package com.example.hotel_app.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.hotel_app.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	//select * from customer where name=:name;
	public Customer findByName(String name);
	
	
}
