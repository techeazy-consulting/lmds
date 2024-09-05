package com.techeazy.lmds.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ParcelRequest {
	
	private String name;
	private long location;
	private String address;
	private long customerId;

}
