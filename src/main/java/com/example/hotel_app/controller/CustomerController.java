package com.example.hotel_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel_app.dto.CustomerProfileDTO;
import com.example.hotel_app.exception.CustomerNotFoundException;
import com.example.hotel_app.model.Customer;
import com.example.hotel_app.model.CustomerProfile;
import com.example.hotel_app.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody CustomerProfileDTO customerProfileDTO){
		//Fetching all the data from DTO, creating empty obejcts of entity classes and setting back
		Customer customer = new Customer();
		customer.setName(customerProfileDTO.getName());
		CustomerProfile customerProfile = new CustomerProfile();
		customerProfile.setAddress(customerProfileDTO.getAddress());
		customerProfile.setIdProof(customerProfileDTO.getIdProof());
		customerProfile.setPhone(customerProfileDTO.getPhone());
		customerProfile.setCustomer(customer);
		customer.setCustomerProfile(customerProfile);
		return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatusCode.valueOf(201));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable Long id) throws CustomerNotFoundException{
	
		Customer customer = customerService.getCustomerById(id);
		if(customer != null)
			return new ResponseEntity<Customer>(customer, HttpStatusCode.valueOf(200));
		else
			return new ResponseEntity<>("Customer not Found : "+id, HttpStatusCode.valueOf(404));
	}
	@GetMapping("/byName/{name}")
	public ResponseEntity<?> getCustomerByName(@PathVariable String name) throws CustomerNotFoundException{
		
		Customer customer = customerService.getCustomerByName(name);
		if(customer != null)
			return new ResponseEntity<Customer>(customer, HttpStatusCode.valueOf(200));
		else
			return new ResponseEntity<>("Customer not Found : "+name, HttpStatusCode.valueOf(404));
	}
	
	
}
