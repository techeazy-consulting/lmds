package com.techeazy.lmds.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderFetchRequest {
	
	private long mobileNumber;
	private String email;
	private String yourIdentity;

}
