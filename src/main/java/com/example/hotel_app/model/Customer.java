package com.example.hotel_app.model;

import jakarta.persistence.*;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String name;
	
	@OneToOne(mappedBy = "customer", cascade  = CascadeType.ALL)
	private CustomerProfile customerProfile;
	
	
	public Customer() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public CustomerProfile getCustomerProfile() {
		return customerProfile;
	}


	public void setCustomerProfile(CustomerProfile customerProfile) {
		this.customerProfile = customerProfile;
	}
	
	

}
