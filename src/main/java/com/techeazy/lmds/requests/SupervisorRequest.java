package com.techeazy.lmds.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SupervisorRequest extends CommonRequest {
	
	private long clientId;
	private long pincode;
	private String address;

}
