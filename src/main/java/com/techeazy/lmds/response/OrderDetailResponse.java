package com.techeazy.lmds.response;

import java.util.List;

import com.techeazy.lmds.entity.Order;
import com.techeazy.lmds.entity.Parcel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailResponse extends CommonResponse {
	private long mobileNum;
	private String clientName;
	private Order orders;
	private List<Parcel> parcels;
}
