package com.techeazy.lmds.service;

import com.techeazy.lmds.requests.OrderDetailRequest;
import com.techeazy.lmds.requests.OrderFetchRequest;
import com.techeazy.lmds.response.OrderDetailResponse;

public interface OrderDetailService {
	
	OrderDetailResponse createOrder(OrderDetailRequest orderRequest);
	
	OrderDetailResponse getOrderOfClient(OrderFetchRequest orderFetchRequest);

}
