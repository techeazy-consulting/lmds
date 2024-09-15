package com.techeazy.lmds.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerRequest extends CommonRequest {
	
	private long parcelId;
	private String name;
	private String address;
	private long pincode;

}
