package com.techeazy.lmds.requests;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailRequest {
	
	private long mobileNumber;
	private String email;
	private String role;
	private String address;
	private long pincode;
	private List<ParcelRequest> parcels;

}
