package com.example.hotel_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel_app.exception.CustomerNotFoundException;
import com.example.hotel_app.model.Customer;
import com.example.hotel_app.model.CustomerProfile;
import com.example.hotel_app.repository.CustomerProfileRepository;
import com.example.hotel_app.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerProfileRepository customerProfileRepository;
	
	public Customer saveCustomer(Customer customerIncomingJsonData) {
		CustomerProfile profile = customerIncomingJsonData.getCustomerProfile();

	    // link both sides of the relationship
	    profile.setCustomer(customerIncomingJsonData);
	    customerIncomingJsonData.setCustomerProfile(profile);

	    // save customer (profile will be saved automatically if cascade is set)
	    return customerRepository.save(customerIncomingJsonData);

	}

	public Customer getCustomerById(Long id) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		
		Customer result = customerRepository.findById(id)
			    .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));
//		if()
		return result;
	}

	public Customer getCustomerByName(String name) throws CustomerNotFoundException{
		// TODO Auto-generated method stub
	
		Customer result = customerRepository.findByName(name);
			 //   .orElseThrow(() -> new CustomerNotFoundException("Customer not found with name: " + name));
		
		if(result != null)
			return result;
		else
			throw new CustomerNotFoundException("Customer not found with name: " + name);
	}
}
