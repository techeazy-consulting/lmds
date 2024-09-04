package com.techeazy.lmds.service;

import org.springframework.http.ResponseEntity;

import com.techeazy.lmds.entity.Client;
import com.techeazy.lmds.entity.Order;
import com.techeazy.lmds.response.OrderDetailResponse;

public interface ClientService {

	ResponseEntity<String> registerUser(Client client);
	OrderDetailResponse getOrderDetail(int clientId);
	OrderDetailResponse uploadOrderDetail(Order Order);
}
