package com.example.hotel_app.dto;

public class CustomerProfileDTO {
	
	private Long customerId;
	
	private String name;
	
	private Long customerProfileId;
	
	private String address;
    private String phone;
    private String idProof;
    
    public CustomerProfileDTO() {
    	
    }
    
    

	public CustomerProfileDTO(Long customerId, String name, Long customerProfileId, String address, String phone,
			String idProof) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.customerProfileId = customerProfileId;
		this.address = address;
		this.phone = phone;
		this.idProof = idProof;
	}



	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCustomerProfileId() {
		return customerProfileId;
	}

	public void setCustomerProfileId(Long customerProfileId) {
		this.customerProfileId = customerProfileId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}



	@Override
	public String toString() {
		return "CustomerProfileDTO [customerId=" + customerId + ", name=" + name + ", customerProfileId="
				+ customerProfileId + ", address=" + address + ", phone=" + phone + ", idProof=" + idProof + "]";
	}
    
    


}
