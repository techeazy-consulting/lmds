package com.techeazy.lmds.requests;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailRequest extends CommonRequest {
	private String address;
	private long pincode;
	private List<ParcelRequest> parcels;

}
